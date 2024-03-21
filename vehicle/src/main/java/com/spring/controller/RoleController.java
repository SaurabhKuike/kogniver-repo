package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.customresponsehandler.CustomResponseHandler;
import com.spring.entity.User;
import com.spring.entity.Vehicle;
import com.spring.repository.VehicleRepository;
import com.spring.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	private UserServiceImpl service;
	@Autowired
	private VehicleRepository repo;
	
	@GetMapping("/user/getallvehicle")
	public ResponseEntity<Object> getallvehicle() {
		List<Vehicle> all = repo.findAll();
		return CustomResponseHandler.responsebuilder("Found All Vehicle", HttpStatus.FOUND,all);
	}
	
	@GetMapping("/user/getvehicle/{id}")
	public ResponseEntity<Object> getvehiclebyid(@PathVariable("id")int id)
	{
		Vehicle vehicle = repo.findById(id).get();
		return CustomResponseHandler.responsebuilder("Found the Vehicle By Id", HttpStatus.FOUND,vehicle);
	}
	
	@PostMapping("/admin/vehicle/insert")
	public ResponseEntity<Object> insertVehicle(@RequestBody Vehicle vehicle)
	{
		Vehicle save = repo.save(vehicle);
		return CustomResponseHandler.responsebuilder("Vehicle Inserted", HttpStatus.FOUND,save);
	}
	
	@GetMapping("/user/getuser/{id}")
	public ResponseEntity<Object> insertUser(@PathVariable("id")int id)
	{
		return CustomResponseHandler.responsebuilder("Found User", HttpStatus.FOUND,service.getUser(id));
	}
	
	@GetMapping("/admin/getalluser")
	public ResponseEntity<Object> getalluser()
	{
		 List<User> getalluser = service.getalluser();
		 return CustomResponseHandler.responsebuilder("Found All Users", HttpStatus.FOUND,getalluser);
	}
	
	@DeleteMapping("/admin/deleteuser/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") int id){
		User deleteUser = service.deleteUser(id);
		return CustomResponseHandler.responsebuilder("User Deleted", HttpStatus.ACCEPTED, deleteUser);
	}
	
}