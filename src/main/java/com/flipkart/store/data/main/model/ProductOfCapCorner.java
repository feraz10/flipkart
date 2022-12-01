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
@Table(name ="product")
public class ProductOfCapCorner implements Serializable {

	private static final long serialVersionUID = 1L;

	

	public ProductOfCapCorner() {
		super();
	}

	public ProductOfCapCorner(int category_id , String productName, String productsize,
			String brandName, String productDescription, String productCode, BigDecimal marketPrice,
			BigDecimal discount, BigDecimal finalPrice) {
		super();
		
		this.category_id=category_id;
		this.productName = productName;
		this.productsize = productsize;
		this.brandName = brandName;
		this.productDescription = productDescription;
		this.productCode = productCode;
		this.marketPrice = marketPrice;
		this.discount = discount;
		this.finalPrice = finalPrice;
	}


	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;

//	@ManyToOne
//	@JoinColumn(name ="category_id")
//	
//	private CategoryOfCapCorner ofCapCorner;




	

	@Column(name ="category_id")
	private int category_id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_size")
	private String productsize;

	@Column(name = "brand_name")
	private String brandName;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "market_price")
	private BigDecimal marketPrice;

	@Column(name = "discount")
	private BigDecimal discount;

	@Column(name = "capcorner_price")
	private BigDecimal finalPrice;



	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductsize() {
		return productsize;
	}

	public void setProductsize(String productsize) {
		this.productsize = productsize;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	





	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

}