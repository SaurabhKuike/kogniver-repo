package com.spring.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.model.User;
import com.spring.model.UserRegisterDto;

public interface UserService extends UserDetailsService {
User save(UserRegisterDto userRegDto);
}