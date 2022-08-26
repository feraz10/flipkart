package com.flipkart.store.data.main.utils;

public class UserRespose {

	private String token;
	private String name;

	public UserRespose(String token) {

		this.token = token;

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserRespose() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
