package com.flipkart.store.data.main.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "placed_order_address")
public class PlacedOrderAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	public PlacedOrderAddress() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "placed_id")
	private int placedId;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private PlacedOrderDetails details;

	@Column(name = "address")
	private String address;

	@Column(name = "landmark")
	private String landmark;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "pincode")
	private int pincode;

	public int getPlacedId() {
		return placedId;
	}

	public void setPlacedId(int placedId) {
		this.placedId = placedId;
	}

	public PlacedOrderDetails getDetails() {
		return details;
	}

	public void setDetails(PlacedOrderDetails details) {
		this.details = details;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
