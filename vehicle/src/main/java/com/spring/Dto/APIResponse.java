package com.spring.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse {

	private String message;
	private boolean status;

	public APIResponse(String message){this.message=message;}
}
