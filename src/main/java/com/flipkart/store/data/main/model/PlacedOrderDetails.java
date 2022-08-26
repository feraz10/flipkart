package com.flipkart.store.data.main.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "placed_order_details")
public class PlacedOrderDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	public PlacedOrderDetails() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	@OneToMany(mappedBy = "details")
	List<PlacedOrderAddress> list1;
	
	@OneToMany(mappedBy = "details")
	List<ProductDetails> list2;
	
	@OneToMany(mappedBy = "details")
	List<Transaction> list3;
	
	
	@Column(name = "order_no")
	private String orderNo;

	@Column(name = "user_mobile")
	private int mobileNo;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "order_status")
	private String orderStatus;

	@Column(name = "order_amount")
	private BigDecimal orderAmount;

	@Column(name = "order_type")
	private String orderType;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	

	

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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

	public List<PlacedOrderAddress> getList1() {
		return list1;
	}

	public void setList1(List<PlacedOrderAddress> list1) {
		this.list1 = list1;
	}

	public List<ProductDetails> getList2() {
		return list2;
	}

	public void setList2(List<ProductDetails> list2) {
		this.list2 = list2;
	}

	public List<Transaction> getList3() {
		return list3;
	}

	public void setList3(List<Transaction> list3) {
		this.list3 = list3;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	

	
	

}