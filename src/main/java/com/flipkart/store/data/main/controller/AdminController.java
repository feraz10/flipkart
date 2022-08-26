package com.flipkart.store.data.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.store.data.main.json.AlertMessage;
import com.flipkart.store.data.main.json.ProductJson;
import com.flipkart.store.data.main.service.CapCornerService;
import com.flipkart.store.data.main.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping(value ="user")
public class AdminController {
	@Autowired
	private ProductService productService;
	
	// post for product and category
		@PostMapping("admin/postproduct")
		public @ResponseBody ResponseEntity<AlertMessage> postpro(@RequestBody ProductJson productJson) {
			AlertMessage msg = new AlertMessage();
			msg = productService.addpoduct(productJson);
			if (msg.getStatusCode() == 400) {
				return new ResponseEntity<AlertMessage>(msg, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<AlertMessage>(msg, HttpStatus.ACCEPTED);
			}
		}
}
