package com.flipkart.store.data.main.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="product_details")
public class ProductDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "details_id")
	private int detailsId;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private PlacedOrderDetails details;
	
	@Column(name = "product_name")
	private String productName;

	

	@Column(name = "market_price")
	private BigDecimal marketPrice;



	@Column(name = "capcorner_price")
	private BigDecimal finalPrice;

	@Column(name = "qty")
	private int qty;

	

	public PlacedOrderDetails getDetails() {
		return details;
	}

	public void setDetails(PlacedOrderDetails details) {
		this.details = details;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
	}

}
