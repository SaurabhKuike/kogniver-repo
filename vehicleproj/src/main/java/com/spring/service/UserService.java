package com.spring.service;

import java.util.List;

import com.spring.Dto.UserDto;
import com.spring.entity.User;


public interface UserService {
	
	User save (UserDto userDto);
	User getUser(int id);
	User deleteUser(int id);
	List<User> getalluser();
}