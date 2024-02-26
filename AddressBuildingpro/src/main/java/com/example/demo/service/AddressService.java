package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;
@Service
public class AddressService {

	@Autowired
	private AddressRepository repo;
	
	public Address insertAddress(Address ad) {
		Address save = repo.save(ad);
		return save;
	}
	
	public List<Address> getAllAddress(){
		List<Address> all = repo.findAll();
		return all;
	}
}
