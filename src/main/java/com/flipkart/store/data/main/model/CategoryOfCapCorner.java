package com.flipkart.store.data.main.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="category")
public class CategoryOfCapCorner implements Serializable {

	private static final long serialVersionUID = 1L;

	public CategoryOfCapCorner() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int categoryId;
	
	@OneToMany(mappedBy ="ofCapCorner")
	List<ProductOfCapCorner> corners;
	
	@Column(name = "category_type")
	private String categorytype;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "category_discription")
	private String categoryDiscription;

	@Column(name = "category_active")
	private String categoryActive;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategorytype() {
		return categorytype;
	}

	public void setCategorytype(String categorytype) {
		this.categorytype = categorytype;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDiscription() {
		return categoryDiscription;
	}

	public void setCategoryDiscription(String categoryDiscription) {
		this.categoryDiscription = categoryDiscription;
	}

	public String getCategoryActive() {
		return categoryActive;
	}

	public void setCategoryActive(String categoryActive) {
		this.categoryActive = categoryActive;
	}

	public List<ProductOfCapCorner> getCorners() {
		return corners;
	}

	public void setCorners(List<ProductOfCapCorner> corners) {
		this.corners = corners;
	}



	
}
