package com.customer.details.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, String>> myConstraintsVoilationException(ConstraintViolationException e) {
		Map<String, String> res = new HashMap<>();

		e.getConstraintViolations().forEach(voilation -> {
			String fieldName = voilation.getPropertyPath().toString();
			String message = voilation.getMessage();

			res.put(fieldName, message);
		});
		System.out.println(res+" ConstraintViolationException");
		return new ResponseEntity<Map<String, String>>(res, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> myMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Map<String, String> res = new HashMap<>();

		e.getBindingResult().getAllErrors().forEach(err -> {
			String fieldName = ((FieldError) err).getField();
			String message = err.getDefaultMessage();

			res.put(fieldName, message);
		});
		System.out.println(res+" MethodArgumentNotValidException");
		return new ResponseEntity<Map<String, String>>(res, HttpStatus.BAD_REQUEST);
	}
}
