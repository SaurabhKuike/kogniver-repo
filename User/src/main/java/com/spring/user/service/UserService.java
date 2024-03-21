package com.spring.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.user.model.User;
import com.spring.user.repository.RoleRepository;
import com.spring.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private PasswordEncoder passwordencoder;
	
	@Autowired
	private RoleRepository rolerepo;
	
	@Autowired
	private UserRepository repo;
	
	public List<User> getalluser(){
		return repo.findAll();
	}
	
	public User getuserbyid(int id)
	{
		return repo.findById(id).get();
	}
	
	public User insertuser(User user)
	{
		User u=new User();
		u.setEmail(user.getEmail());
		u.setRoles(user.getRoles());
		u.setUsername(user.getUsername());
		u.setUser_id(user.getUser_id());
		u.setPassword(passwordencoder.encode(user.getPassword()));
		repo.save(u);
		return u;
	}
	
	public void deleteUser(int id)
	{
		repo.deleteById(id);
	}
}
