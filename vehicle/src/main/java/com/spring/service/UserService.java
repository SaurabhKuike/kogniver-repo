package com.spring.service;

import java.util.List;

import com.spring.Dto.UserDto;
import com.spring.entity.User;

/**
 * User Service Interface contains all method to be implemented for User Specific operation
 */
public interface UserService {
	
	User save (UserDto userDto);
	User getUser(int id);
	User deleteUser(int id);
	List<User> getalluser();
}