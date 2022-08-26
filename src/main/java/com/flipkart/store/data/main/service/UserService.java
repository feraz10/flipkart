package com.flipkart.store.data.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flipkart.store.data.main.model.User;
import com.flipkart.store.data.main.repository.UserRepository;
@Service

public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User customerModel = customerRepository.getByEmail(username);
		if(customerModel == null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("no user found ");
		}
		return customerModel;
	}

}
