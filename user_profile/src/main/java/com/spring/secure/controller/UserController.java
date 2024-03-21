package com.spring.secure.controller;



import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.secure.dto.UserDto;
import com.spring.secure.model.User;
import com.spring.secure.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/admin/getuser/{id}")
	public User getuser(@PathVariable("id")Long id)
	{
		User user = userService.getUser(id);
		return user;
	}
	
	@GetMapping("/admin/getalluser")
	public List<User> getalluser()
	{
		return userService.getalluser();
	}
	
	@DeleteMapping("/admin/deleteuser/{id}")
	public User deleteuser(@PathVariable("id")Long id)
	{
		User user = userService.deleteUser(id);
		return user;
	}
	
	@GetMapping("/user/home")
	public String userHome()
	{
		return "Welcome User Home Page";
	}
	
}