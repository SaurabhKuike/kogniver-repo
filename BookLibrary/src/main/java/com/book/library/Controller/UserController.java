package com.book.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.library.Model.User;
import com.book.library.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/getuser/{id}")
	public ResponseEntity<User> getuserbyid(@PathVariable("id")int id){
		
		return new ResponseEntity<>(service.getUser(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<List<User>> getAllUser(){
		
		return new ResponseEntity<>(service.getAllUser(),HttpStatus.FOUND);
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestBody User b)
	{
		boolean book = service.adduser(b);
		if(book)
		{
			return new ResponseEntity<User>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
	}
	
}
