package com.spring.customresponsehandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * this class is for generating custom response
 */
public class CustomResponseHandler {

	public static ResponseEntity<Object> responsebuilder(String message,HttpStatus status, Object responseobject)
	{
		Map<String, Object> response= new HashMap<>();
		response.put("message", message);
		response.put("status", status);
		response.put("response", responseobject);
		return new ResponseEntity<>(response,status);
	}
}
