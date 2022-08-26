package com.flipkart.store.data.main.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.store.data.main.json.AddressJson;
import com.flipkart.store.data.main.json.AlertMessage;
import com.flipkart.store.data.main.json.CancelOrderJson;
import com.flipkart.store.data.main.json.InvoiveJson;

import com.flipkart.store.data.main.json.PlacedOrderJson;
import com.flipkart.store.data.main.json.ProductDetailsJson;
import com.flipkart.store.data.main.json.ProductJson;
import com.flipkart.store.data.main.json.TransactionJson;
import com.flipkart.store.data.main.model.CategoryOfCapCorner;
import com.flipkart.store.data.main.model.InvoiceOrder;
import com.flipkart.store.data.main.model.PlacedOrderAddress;
import com.flipkart.store.data.main.model.PlacedOrderDetails;
import com.flipkart.store.data.main.model.ProductDetails;
import com.flipkart.store.data.main.model.ProductOfCapCorner;
import com.flipkart.store.data.main.model.Refund;
import com.flipkart.store.data.main.model.Transaction;
import com.flipkart.store.data.main.model.User;
import com.flipkart.store.data.main.repository.CategoryRepo;
import com.flipkart.store.data.main.repository.Orderinvicerepository;
import com.flipkart.store.data.main.repository.PlacedOrderAddresRepo;
import com.flipkart.store.data.main.repository.PlacedOrderDetailsRepo;
import com.flipkart.store.data.main.repository.ProductDetailsRepository;
import com.flipkart.store.data.main.repository.ProductRepo;
import com.flipkart.store.data.main.repository.RefundRepo;
import com.flipkart.store.data.main.repository.TransactionRepository;
import com.flipkart.store.data.main.repository.UserRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;
	@Autowired
	CategoryRepo categoryRepo;
	@Autowired
	PlacedOrderDetailsRepo detailsRepo;
	@Autowired
	ProductDetailsRepository productDetailsRepository;
	@Autowired
	PlacedOrderAddresRepo placedOrderAddresRepo;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RefundRepo refundRepo;
	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	Orderinvicerepository orderinvicerepository;
	// ----->>>> for post product details

	public AlertMessage addpoduct(ProductJson productJson) {

		AlertMessage msg1 = new AlertMessage();
		Optional<CategoryOfCapCorner> addproduct = categoryRepo.addproduct(productJson.getCategoryId());

		if (addproduct.isPresent()) {
			msg1.setMessage("Category already registerd");
			msg1.setStatusCode(400);
		} else {

			CategoryOfCapCorner cc = new CategoryOfCapCorner();
			cc.setCategoryId(productJson.getCategoryId());
			cc.setCategoryName(productJson.getCategoryName());
			cc.setCategorytype(productJson.getCategorytype());
			cc.setCategoryDiscription(productJson.getCategoryDiscription());
			cc.setCategoryActive(productJson.getCategoryActive());
			categoryRepo.save(cc);

			ProductOfCapCorner pj = new ProductOfCapCorner();
			pj.setProductId(productJson.getProductId());
			pj.setProductName(productJson.getProductName());
			pj.setBrandName(productJson.getBrandName());
			pj.setProductCode(productJson.getProductCode());
			pj.setDiscount(productJson.getDiscount());
			pj.setFinalPrice(productJson.getFinalPrice());
			pj.setMarketPrice(productJson.getMarketPrice());
			pj.setProductDescription(productJson.getProductDescription());
			pj.setProductsize(productJson.getProductsize());
			productRepo.save(pj);

			msg1.setMessage("product details are added");
			msg1.setStatusCode(201);
		}
		return msg1;

	}

// ---===---->>>> for find product details-------------------<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	public List<ProductJson> getproduct(String productName) {
		List<ProductJson> lop = new ArrayList<ProductJson>();

		Optional<ProductOfCapCorner> pocc = productRepo.findByProductName(productName);

		if (pocc.isPresent()) {

			ProductOfCapCorner p = pocc.get();

			ProductJson pj = new ProductJson();
			pj.setProductName(p.getProductName());
			pj.setBrandName(p.getBrandName());
			pj.setProductDescription(p.getProductDescription());
			pj.setProductsize(p.getProductsize());
			pj.setMarketPrice(p.getMarketPrice());
			pj.setDiscount(p.getDiscount());
			pj.setFinalPrice(p.getFinalPrice());

			lop.add(pj);
		}

		return lop;
	}

	// ----->>>>>>>>>>>>>>>>> for placed
	// order--------------------<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	public InvoiveJson addpoduct(PlacedOrderJson json) {
		InvoiveJson me = new InvoiveJson();
		String orderNo = createOrderNumber();
		String transactionId = createOrderTransactionId();
		Optional<User> addorder = userRepository.findByMobileNo(json.getMobileNo());

		if (addorder.isPresent() && json.getOrderType().equalsIgnoreCase("COD")) {

			PlacedOrderDetails p = new PlacedOrderDetails();

			p.setOrderNo(orderNo);
			p.setMobileNo(json.getMobileNo());
			p.setOrderAmount(json.getOrderAmount());
			p.setOrderDate(new Date());
			p.setOrderType(json.getOrderType());
			p.setOrderStatus("pending");
			detailsRepo.save(p);
			List<ProductDetailsJson> pdj = json.getDetailsJsons();

			for (ProductDetailsJson i : pdj) {

				ProductDetails pd = new ProductDetails();
				pd.setDetails(p);
				pd.setProductName(i.getProductName());
				pd.setMarketPrice(i.getMarketPrice());
				pd.setFinalPrice(i.getFinalPrice());
				pd.setQty(i.getQty());
				productDetailsRepository.save(pd);
			}
			List<AddressJson> aj = json.getAddressJsons();
			for (AddressJson a : aj) {
				PlacedOrderAddress pp = new PlacedOrderAddress();
				pp.setDetails(p);
				pp.setLandmark(a.getLandmark());
				pp.setAddress(a.getAddress());
				pp.setCity(a.getCity());
				pp.setPincode(a.getPincode());
				pp.setState(a.getState());
				placedOrderAddresRepo.save(pp);

			}

			me.setMessage("Thanku for Shoping");
			me.setStatusCode(200);

		} else if (addorder.isPresent() && json.getOrderType().equalsIgnoreCase("Online")) {
			PlacedOrderDetails p = new PlacedOrderDetails();

			p.setOrderNo(orderNo);
			p.setMobileNo(json.getMobileNo());
			p.setOrderAmount(new BigDecimal("0.00"));
			p.setOrderDate(new Date());
			p.setOrderType(json.getOrderType());
			p.setOrderStatus("pending");
			detailsRepo.save(p);
			List<ProductDetailsJson> pdj = json.getDetailsJsons();

			for (ProductDetailsJson i : pdj) {

				ProductDetails pd = new ProductDetails();
				pd.setDetails(p);
				pd.setProductName(i.getProductName());
				pd.setMarketPrice(new BigDecimal("0.00"));
				pd.setFinalPrice(new BigDecimal("0.00"));
				pd.setQty(i.getQty());
				productDetailsRepository.save(pd);
			}
			List<AddressJson> aj = json.getAddressJsons();
			for (AddressJson a : aj) {
				PlacedOrderAddress pp = new PlacedOrderAddress();
				pp.setDetails(p);
				pp.setLandmark(a.getLandmark());
				pp.setAddress(a.getAddress());
				pp.setCity(a.getCity());
				pp.setPincode(a.getPincode());
				pp.setState(a.getState());
				placedOrderAddresRepo.save(pp);
			}
			List<TransactionJson> pk = json.getTransactionJsons();

			for (TransactionJson i : pk) {

				Transaction ts = new Transaction();
				ts.setDetails(p);
				ts.setTransactionId(transactionId);
				ts.setTransactionDate(new Date());
				ts.setTransactionDescription(i.getTransactionDescription());
				ts.setOrderAmount(new BigDecimal("0.00"));
				transactionRepository.save(ts);
			}
			me.setMessage("Thanku for Shoping");
			me.setStatusCode(200);
		} else {
			me.setMessage("User is not found Please Register");
			me.setStatusCode(400);
		}

		return me;

	}

	private String createOrderTransactionId() {
		DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		String requireDate = dft.format(new Date()).toString(); // to convert in string format
		Integer dateWiseOrder = 0;
		String transactionId = "CC/TR/NO";
		List<Object[]> obj = orderinvicerepository.findByDate(requireDate);

		for (Object[] objects : obj) {
			dateWiseOrder = (Integer) objects[1];
		}
		dateWiseOrder++;
		DateFormat df1 = new SimpleDateFormat("YYMMdd");
		String orderDate = df1.format(new Date()).toString();
		transactionId = transactionId + "" + orderDate + "0" + dateWiseOrder;

		return transactionId;
	}

	private String createOrderNumber() {
		DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		String requireDate = dft.format(new Date()).toString(); // to convert in string format
		Integer dateWiseOrder = 0;
		String orderNo = "CC";
		List<Object[]> obj = orderinvicerepository.findByDate(requireDate);

		for (Object[] objects : obj) {
			dateWiseOrder = (Integer) objects[1];
		}
		dateWiseOrder++;
		DateFormat df1 = new SimpleDateFormat("YYMMdd");
		String orderDate = df1.format(new Date()).toString();
		orderNo = orderNo + "" + orderDate + "0" + dateWiseOrder;

		InvoiceOrder order = new InvoiceOrder();
		order.setOrderDate(new Date());
		order.setPerdayOrder(dateWiseOrder);
		order.setOrderNo(orderNo);

		orderinvicerepository.save(order);
		return orderNo;
	}
	
	
	// -->>>>>>>>>>>>>>>>>Cancel Order<<<<<<<<<<<<<<<<<<
	public AlertMessage updateorder(CancelOrderJson json) {
	//	String transactionId = createTransactionId();
		String acoountNo = createAcoountNo();
		AlertMessage ms = new AlertMessage();
		PlacedOrderDetails placedOrderDetails = null;
		
			Optional<PlacedOrderDetails> cancel = detailsRepo.findById(json.getOrderId());
			if (cancel.isPresent()) {
				placedOrderDetails = cancel.get();

				if (placedOrderDetails.getOrderStatus().equalsIgnoreCase("Deliverd")) {
					ms.setMessage("Product Deliverd");
					ms.setStatusCode(200);

				} else if (placedOrderDetails.getOrderStatus().equalsIgnoreCase("Pending")) {
					ms.setMessage("Product Pending");
					ms.setStatusCode(400);
					placedOrderDetails.setOrderStatus("Order Cancel");
					detailsRepo.save(placedOrderDetails);

					List<Transaction> transactions = placedOrderDetails.getList3();
					for (Transaction transaction : transactions) {
							Refund rf = new Refund();
							rf.setTransactionId(transaction.getTransactionId());
							rf.setCreatedOn(new Date());
							rf.setMobileNo(placedOrderDetails.getMobileNo());
							rf.setOrderId(placedOrderDetails.getOrderId());
							rf.setOrderTotalAmount(new BigDecimal("0.00"));
							rf.setProcessingFee(new BigDecimal("0.00"));
							rf.setRefund_Complete(new Date());
							rf.setOrderType(placedOrderDetails.getOrderType());
							rf.setAcoountNo(acoountNo);
							refundRepo.save(rf);

						
							
					
					ms.setMessage("Order Canceled Succesfully");
					ms.setStatusCode(201);}
				} else {
					ms.setMessage("Order Cancelation Failed");
					ms.setStatusCode(400);
				}
			} else {
				ms.setMessage("Data Not Found in DB");
				ms.setStatusCode(400);
			}
			return ms;
		
}
	private String createAcoountNo() {
		DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		String requireDate = dft.format(new Date()).toString(); // to convert in string format
		Integer dateWiseOrder = 0;
		String acoountNo = "A/C/NO";
		List<Object[]> obj = orderinvicerepository.findByDate(requireDate);

		for (Object[] objects : obj) {
			dateWiseOrder = (Integer) objects[1];
		}
		dateWiseOrder++;
		DateFormat df1 = new SimpleDateFormat("YYMMdd");
		String orderDate = df1.format(new Date()).toString();
		acoountNo = acoountNo + "" + orderDate + "0" + dateWiseOrder;

		return acoountNo;
	}


//---->>>>>>>>>>>>>>>>>>>>>get product details<<<<<<<<<<-----------
	public List<PlacedOrderJson> findOrder(int mobileNo) {

		List<PlacedOrderJson> list3 = new ArrayList<PlacedOrderJson>();

		Optional<PlacedOrderDetails> order = detailsRepo.findByMobileNo(mobileNo);
		if (order.isPresent()) {

			PlacedOrderDetails cm3 = order.get();

			PlacedOrderJson oj = new PlacedOrderJson();
			oj.setMobileNo(cm3.getMobileNo());
			oj.setOrderId(cm3.getOrderId());
			oj.setOrderAmount(cm3.getOrderAmount());
			oj.setOrderNo(cm3.getOrderNo());
			oj.setOrderDate(cm3.getOrderDate());
			oj.setOrderType(cm3.getOrderType());

			List<PlacedOrderAddress> cm4 = cm3.getList1();
			List<AddressJson> list5 = new ArrayList<AddressJson>();

			for (PlacedOrderAddress j : cm4) {

				AddressJson pj = new AddressJson();

				pj.setAddress(j.getAddress());
				pj.setCity(j.getCity());
				pj.setLandmark(j.getLandmark());
				pj.setState(j.getState());
				pj.setPincode(j.getPincode());

				list5.add(pj);
				oj.setAddressJsons(list5);
			}

			List<ProductDetails> cm5 = cm3.getList2();
			List<ProductDetailsJson> li = new ArrayList<ProductDetailsJson>();
			for (ProductDetails k : cm5) {
				ProductDetailsJson p = new ProductDetailsJson();

				p.setProductName(k.getProductName());
				p.setQty(k.getQty());
				p.setMarketPrice(k.getMarketPrice());
				p.setFinalPrice(k.getFinalPrice());
				li.add(p);
				oj.setDetailsJsons(li);

			}

			list3.add(oj);
		}

		return list3;
	}

}