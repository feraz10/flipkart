package com.flipkart.store.data.main.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "refund_details")
public class Refund implements Serializable {

	private static final long serialVersionUID = 1L;

	public Refund() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int refundId;

	@Column(name = "order_id")
	private int orderId;
	

	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "user_mobile")
	private int mobileNo;

	@Column(name = "order_total_amount")
	private BigDecimal orderTotalAmount;
	

	@Column(name = "processing_fee")
	private BigDecimal processingFee;
	

	@Column(name = "refund_Date")
	private Date refund_Complete;

	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "order_type")
	private String orderType;
	
	@Column(name="account_no")
	private String acoountNo;

	public int getRefundId() {
		return refundId;
	}

	public void setRefundId(int refundId) {
		this.refundId = refundId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public BigDecimal getOrderTotalAmount() {
		return orderTotalAmount;
	}

	public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}

	public BigDecimal getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(BigDecimal processingFee) {
		this.processingFee = processingFee;
	}

	public Date getRefund_Complete() {
		return refund_Complete;
	}

	public void setRefund_Complete(Date refund_Complete) {
		this.refund_Complete = refund_Complete;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

	public String getAcoountNo() {
		return acoountNo;
	}

	public void setAcoountNo(String acoountNo) {
		this.acoountNo = acoountNo;
	}

}
