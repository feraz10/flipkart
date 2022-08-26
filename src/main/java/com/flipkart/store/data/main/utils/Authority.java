package com.flipkart.store.data.main.utils;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

	// extend granted authority
	
	private String  authority;
	
	public Authority(String authority) {
		
		this.authority=authority;
	}
	
	
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

}
