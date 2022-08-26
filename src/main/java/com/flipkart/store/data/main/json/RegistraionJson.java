package com.flipkart.store.data.main.json;

import java.util.Date;
import java.util.List;



public class RegistraionJson {
	private int id;
	private String customerName;

	private int mobileNo;

	private String email;

	private String password;

	private String city;

	private Date registrationateDate;
	private String address;

	private String landmark;

	private int areapincode;

	
	private List<UserAddressJson>userAddressJsons;
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getRegistrationateDate() {
		return registrationateDate;
	}

	public void setRegistrationateDate(Date registrationateDate) {
		this.registrationateDate = registrationateDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<UserAddressJson> getUserAddressJsons() {
		return userAddressJsons;
	}

	public void setUserAddressJsons(List<UserAddressJson> userAddressJsons) {
		this.userAddressJsons = userAddressJsons;
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

	public int getAreapincode() {
		return areapincode;
	}

	public void setAreapincode(int areapincode) {
		this.areapincode = areapincode;
	}

	

}