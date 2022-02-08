package com.learning.springsecurityjwt.rest.response;

public class AuthenticationResponse {
	
	private String jwt;

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	

}
