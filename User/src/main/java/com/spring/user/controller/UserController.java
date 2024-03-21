package com.spring.user.controller;

import java.util.List;

import org.aspectj.lang.annotation.DeclareMixin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.user.model.User;
import com.spring.user.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService service;
	
	
	
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Home Page";
	}
	
	@GetMapping("/user/userprofile")
	public String userProfile() {
		return "Welcome to user Profile";
	}
	
	@GetMapping("/admin/adminprofile")
	public String adminProfile() {
		return "Welcome to Admin Profile";
	}
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		service.insertuser(user);
		return "user register";
	}
	
	@GetMapping("/user/getusers")
	public List<User> getalluser() {
		List<User> getalluser = service.getalluser();
		return getalluser;
	}
	
	@GetMapping("/user/getuser/{id}")
	public User getUser(@PathVariable("id")int id)
	{
		return service.getuserbyid(id);
	}
	
	@DeleteMapping("/admin/delete/{id}")
	public String deleteUser(@PathVariable("id")int id)
	{
		service.deleteUser(id);
		return "user deleted";
	}
}
