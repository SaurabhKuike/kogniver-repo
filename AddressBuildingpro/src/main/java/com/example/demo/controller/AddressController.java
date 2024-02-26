package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService service;
	@PostMapping("/addAddress")
	public ResponseEntity<Address> insertAddress(@RequestBody Address ad) {
		Address insertAddress = service.insertAddress(ad);
		return new ResponseEntity<>(insertAddress,HttpStatus.OK);
	}
	@GetMapping("/getAllAddress")
	public ResponseEntity<List<Address>> getAddress(){
		List<Address> allAddress = service.getAllAddress();
		return new ResponseEntity<>(allAddress,HttpStatus.OK);
	}
}
