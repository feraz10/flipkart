package com.flipkart.store.data.main.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderinvice")
public class InvoiceOrder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvoiceOrder() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "order_no")
	private String orderNo;

	@Column(name = "Order_Date")
	private Date orderDate;

	@Column(name = "per_dayOrder")
	private int perdayOrder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getPerdayOrder() {
		return perdayOrder;
	}

	public void setPerdayOrder(int perdayOrder) {
		this.perdayOrder = perdayOrder;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

}
