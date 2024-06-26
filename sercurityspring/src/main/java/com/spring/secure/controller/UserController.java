package com.spring.secure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "securityspring")
public class UserController {

	@GetMapping("/home")
	public String home()
	{
		return "Welcome to Home";
	}
	
	@GetMapping("/user")
	public String normaluser() {
		return "normal user page";
	}
	
	@GetMapping("/admin")
		public String adminuser() {
		return "admin user page";
	}
}
