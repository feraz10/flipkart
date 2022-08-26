package com.flipkart.store.data.main.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.flipkart.store.data.main.service.UserService;

import io.jsonwebtoken.ExpiredJwtException;

//  Run before every request and take information from header and validate 
@Component
public class JwtFilter extends OncePerRequestFilter {
	@Autowired
	private UserService userService;
	@Autowired
	private TokenManager tokenManager;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		final String requestTokenHeader = request.getHeader("Authorization");
		System.out.println(requestTokenHeader);

		String eamil = null;
		String token = null;

		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {

			token = requestTokenHeader.substring(7);
			try {
				eamil = this.tokenManager.getUsernameFromToken(token);
			} catch (ExpiredJwtException e) {
				e.printStackTrace();
				System.out.println("taken has expired");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
		} else {
			System.out.println("invalid token not  start with bearrr");
		}
		if (eamil != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			final UserDetails userDetails = this.userService.loadUserByUsername(eamil);

			if (this.tokenManager.validateJwtToken(token, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		} else {
			System.out.println("token is not valid");
		}
		filterChain.doFilter(request, response);
	}

}
