package com.flipkart.store.data.main.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "transactional_deatils")
@NamedQuery(name="Transaction.findAll", query="SELECT s FROM Transaction s")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	public Transaction() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tr_id")
	private int trId;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private PlacedOrderDetails details;

	@Column(name = "transaction_date")
	private Date transactionDate;

	@Column(name = "order_amount")
	private BigDecimal orderAmount;

	@Column(name = "transaction_description")
	private String transactionDescription;
	@Column(name = "transaction_id")
	private String transactionId;
	

	public PlacedOrderDetails getDetails() {
		return details;
	}

	public void setDetails(PlacedOrderDetails details) {
		this.details = details;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getTrId() {
		return trId;
	}

	public void setTrId(int trId) {
		this.trId = trId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}
