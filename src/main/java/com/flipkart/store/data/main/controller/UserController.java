package com.flipkart.store.data.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.store.data.main.json.AlertMessage;
import com.flipkart.store.data.main.json.CancelOrderJson;
import com.flipkart.store.data.main.json.InvoiveJson;
import com.flipkart.store.data.main.json.RegistraionJson;
import com.flipkart.store.data.main.json.UserAddressJson;
import com.flipkart.store.data.main.json.LoginJson;

import com.flipkart.store.data.main.json.PlacedOrderJson;
import com.flipkart.store.data.main.json.ProductJson;
import com.flipkart.store.data.main.service.CapCornerService;
import com.flipkart.store.data.main.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private CapCornerService cornerService;
	@Autowired
	private ProductService productService;

	// ------->>>>PostMapping for Registration<<<<<<<<

	@PostMapping("admin/C1/registration")

	public @ResponseBody ResponseEntity<AlertMessage> logged(@RequestBody RegistraionJson registraionJson) {

		AlertMessage ms = new AlertMessage();

		ms = cornerService.authentication(registraionJson);

		if (ms.getStatusCode() == 400) {
			return new ResponseEntity<AlertMessage>(ms, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<AlertMessage>(ms, HttpStatus.ACCEPTED);
		}

	}

	@PostMapping("admin/C1/AddAddress")
	public @ResponseBody ResponseEntity<AlertMessage> newaddress(@RequestBody UserAddressJson registraionJson) {

		AlertMessage ms = new AlertMessage();

		ms = cornerService.addAdd(registraionJson);

		if (ms.getStatusCode() == 400) {
			return new ResponseEntity<AlertMessage>(ms, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<AlertMessage>(ms, HttpStatus.ACCEPTED);
		}

	}

	// ------->>>>for Login

	@PostMapping("admin/C2/User/Login")

	public @ResponseBody ResponseEntity<AlertMessage> enter(@RequestBody LoginJson loginJson) {

		AlertMessage msg5 = new AlertMessage();
		msg5 = cornerService.verification(loginJson);

		if (msg5.getStatusCode() == 400) {
			return new ResponseEntity<AlertMessage>(msg5, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<AlertMessage>(msg5, HttpStatus.ACCEPTED);
		}

	}

	// ----->>>> for find product details
	@GetMapping("admin/getproduct")

	public @ResponseBody ResponseEntity<List<ProductJson>> getpro(
			@RequestParam(value = "product_name", required = true) String productName) {

		List<ProductJson> get = new ArrayList<ProductJson>();
		get = productService.getproduct(productName);
		return new ResponseEntity<List<ProductJson>>(get, HttpStatus.OK);
	}

	// ---->>>> for placed order
	@PostMapping("admin/placeOrder")
	public @ResponseBody ResponseEntity<InvoiveJson> orderadd(@RequestBody PlacedOrderJson json) {
		InvoiveJson mess = new InvoiveJson();
		mess = productService.addpoduct(json);
			return new ResponseEntity<InvoiveJson>(mess, HttpStatus.OK);
		
	}
	
	@GetMapping("admin/OrderDetails")
	public @ResponseBody ResponseEntity<List<PlacedOrderJson>>getOrder(@RequestParam(value = "user_mobile", required = true) int mobileNo){
		List<PlacedOrderJson> lj=new ArrayList<PlacedOrderJson>();
		lj=productService.findOrder(mobileNo);
		return new ResponseEntity<List<PlacedOrderJson>>(lj,HttpStatus.OK);
	}

	
	@PutMapping("admin/cancelOrder")
	public @ResponseBody ResponseEntity<AlertMessage> cancel(@RequestBody CancelOrderJson json) {
		AlertMessage sms = new AlertMessage();
		sms = productService.updateorder(json);
		if (sms.getStatusCode() == 400) {
			return new ResponseEntity<AlertMessage>(sms, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<AlertMessage>(sms, HttpStatus.ACCEPTED);
		}
	}

}