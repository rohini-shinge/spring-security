package com.learning.springsecurityjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
	
	@GetMapping(path="/hello")
	public String hello()
	{
		return "Hello Avani Shinge";
	}

}
