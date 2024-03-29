package com.spring.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.Dto.UserDto;
import com.spring.entity.User;
import com.spring.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private PasswordEncoder passwordencoder;
	
	
	@Autowired
	private UserRepository repo;
	
	public List<User> getalluser(){
		return repo.findAll();
	}
	
	public User getUser(int id)
	{
		return repo.findById(id).get();
	}
	
	public User save(UserDto user)
	{
		User u=new User();
		u.setEmail(user.getEmail());
		u.setRoles(user.getRole());
		u.setUsername(user.getFullname());
		u.setUser_id(user.getId());
		u.setPassword(passwordencoder.encode(user.getPassword()));
		repo.save(u);
		return u;
	}
	
	public User deleteUser(int id)
	{
		User user = repo.findById(id).get();
		repo.deleteById(id);
		return user;
	}

}