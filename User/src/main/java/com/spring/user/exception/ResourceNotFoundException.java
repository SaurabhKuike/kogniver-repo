package com.spring.user.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
}