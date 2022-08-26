package com.flipkart.store.data.main.json;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



public class PlacedOrderJson {
	private int orderId;
	
	private int mobileNo;
	private String orderNo;
	private Date orderDate;
	private BigDecimal orderAmount;
	private String orderType;

	private List<AddressJson> addressJsons;
	private List<ProductDetailsJson> detailsJsons;
	private List<TransactionJson> transactionJsons;
	private List<InvoiveJson>invoiveJsons;
	
	
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public BigDecimal getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<ProductDetailsJson> getDetailsJsons() {
		return detailsJsons;
	}
	public void setDetailsJsons(List<ProductDetailsJson> detailsJsons) {
		this.detailsJsons = detailsJsons;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	public List<TransactionJson> getTransactionJsons() {
		return transactionJsons;
	}
	public void setTransactionJsons(List<TransactionJson> transactionJsons) {
		this.transactionJsons = transactionJsons;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public List<InvoiveJson> getInvoiveJsons() {
		return invoiveJsons;
	}
	public void setInvoiveJsons(List<InvoiveJson> invoiveJsons) {
		this.invoiveJsons = invoiveJsons;
	}
	public List<AddressJson> getAddressJsons() {
		return addressJsons;
	}
	public void setAddressJsons(List<AddressJson> addressJsons) {
		this.addressJsons = addressJsons;
	}
	
	 
}
