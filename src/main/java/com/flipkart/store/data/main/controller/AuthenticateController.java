
package com.flipkart.store.data.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.store.data.main.config.TokenManager;


import com.flipkart.store.data.main.service.UserService;
import com.flipkart.store.data.main.utils.UserRequest;
import com.flipkart.store.data.main.utils.UserRespose;

@RestController
@CrossOrigin
public class AuthenticateController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;
	@Autowired
	private TokenManager tokenManager;

	// generate token
	@PostMapping("generate-token")
	public ResponseEntity<UserRespose> generateToken(@RequestBody UserRequest userRequest) throws Exception {

		try {
			authenticate(userRequest.getEmail(), userRequest.getPassword());
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("user not found ");
		}
		UserDetails userDetails = userService.loadUserByUsername(userRequest.getEmail());
		String token = tokenManager.generateJwtToken(userDetails);
		return ResponseEntity.ok(new UserRespose(token));

		
	}

	private void authenticate(String email, String password) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new Exception("USER DISABLE" + e.getMessage());
		} catch (BadCredentialsException e) {
			throw new Exception("Bad Credencials" + e.getMessage());
		}

	}

}
