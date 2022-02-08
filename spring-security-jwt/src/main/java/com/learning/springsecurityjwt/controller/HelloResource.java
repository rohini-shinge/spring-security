package com.learning.springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springsecurityjwt.rest.request.AuthenticationRequest;
import com.learning.springsecurityjwt.rest.response.AuthenticationResponse;
import com.learning.springsecurityjwt.service.MyUserDetailsService;
import com.learning.springsecurityjwt.util.JWTUtil;

@RestController
public class HelloResource {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	
	@GetMapping(path="/hello")
	public String hello()
	{
		return "Hello Avani Shinge";
	}
	
	@PostMapping(path="/authenticate")
	public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
	{
		try
		{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
				(authenticationRequest.getUsername(), authenticationRequest.getPassword()))	;
		}
		catch (BadCredentialsException e) {
			
			throw new Exception("Incorrect Username or password");
		}
		
		final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt=jwtUtil.generateToken(userDetails);
		
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}

}
