package com.flipkart.store.data.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.flipkart.store.data.main.json.AlertMessage;
import com.flipkart.store.data.main.json.RegistraionJson;
import com.flipkart.store.data.main.json.UserAddressJson;
import com.flipkart.store.data.main.json.LoginJson;

import com.flipkart.store.data.main.model.User;
import com.flipkart.store.data.main.model.UserAddress;
import com.flipkart.store.data.main.repository.UserRepository;

import com.flipkart.store.data.main.repository.UserAddreRepository;

@Service
public class CapCornerService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserAddreRepository newaddrRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// -------> Business Logics for Registration<-----

	public AlertMessage authentication(RegistraionJson registraionJson) {

		AlertMessage mg2 = new AlertMessage();

		Optional<User> log = userRepository.newuser(registraionJson.getMobileNo(), registraionJson.getEmail());

		if (log.isPresent()) {
			mg2.setMessage("Number or Email Already Registered");
			mg2.setStatusCode(400);

		} else {

			User lm = new User();

			lm.setId(registraionJson.getId());
			lm.setCustomerName(registraionJson.getCustomerName());
			lm.setMobileNo(registraionJson.getMobileNo());
			lm.setEmail(registraionJson.getEmail());
			lm.setPassword(passwordEncoder.encode(registraionJson.getPassword()));
			lm.setCity(registraionJson.getCity());
			lm.setRegistrationateDate(registraionJson.getRegistrationateDate());
			userRepository.save(lm);

			mg2.setMessage("Welcome to Cap Corner");
			mg2.setStatusCode(201);
		}

		return mg2;
	}

	// -----> Add New  Address<-----
	public AlertMessage addAdd(UserAddressJson registraionJson) {
		AlertMessage m = new AlertMessage();
		Optional<User> l = userRepository.findByMobileNo(registraionJson.getMobileNo());
		if (l.isPresent()) {
			
			User lm =l.get();

			

				UserAddress n = new UserAddress();
				n.setUser(lm);
				n.setAddress(registraionJson.getAddress());
				n.setCity(registraionJson.getCity());
				n.setAreapincode(registraionJson.getAreapincode());
				n.setLandmark(registraionJson.getLandmark());
				
				
				newaddrRepository.save(n);
				
				m.setMessage("Added New Address");
				m.setStatusCode(201);
			}
			
		
		return m;

	}
	// ------------------> Logics login <----------------

	public AlertMessage verification(LoginJson loginJson) {
		User model;
		AlertMessage msg = new AlertMessage();
		Optional<User> ver = userRepository.verifing(loginJson.getMobileNo(), loginJson.getEmail());

		if (ver.isPresent()) {
			model = ver.get();
			if (model.getPassword().equals(loginJson.getPassword())) {

				msg.setMessage("it's so good to have you back!");
				msg.setStatusCode(202);

			} else {
				msg.setMessage("Please enter correct Email or Passsword");
				msg.setStatusCode(400);
			}

		} else {
			msg.setMessage("Sorry your account is not created");

			msg.setStatusCode(400);
		}
		return msg;
	}

}