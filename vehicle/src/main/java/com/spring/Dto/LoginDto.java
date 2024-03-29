package com.spring.Dto;

import lombok.Data;

@Data
/**
 * Data Access Layer for logging in user
 */
public class LoginDto {

	private String email;
	private String password;
	
}
