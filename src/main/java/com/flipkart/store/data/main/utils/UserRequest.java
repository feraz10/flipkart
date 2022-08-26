package com.flipkart.store.data.main.utils;

public class UserRequest {

	private int mobileNo;

	private String email;

	private String password;

	public UserRequest() {

	}

	public UserRequest(String email, String password, int mobileNo) {

		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;

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

}
