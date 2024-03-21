package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Service.VehicleService;
import com.spring.entity.Vehicle;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService service;
	
	@GetMapping("/home")
	public String home() {
		return "this url can be accessed by any role";
	}
	@GetMapping
	public String login() {
		return "user login";
	}
	@PostMapping("/admin/vehicle/insert")
	public ResponseEntity<Vehicle> insertVehicle(@RequestBody Vehicle v)
	{
		Vehicle insertVehicle = service.insertVehicle(v);
		return new ResponseEntity<Vehicle>(insertVehicle,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/vehicle/get/{id}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("id")int id)
	{
		Vehicle vehicle = service.getVehicle(id);
		return new ResponseEntity<Vehicle>(vehicle,HttpStatus.FOUND);
	}
	
	@GetMapping("/user/vehicle/get")
	public ResponseEntity<List<Vehicle>> getallVehicle()
	{
		List<Vehicle> vehicle = service.getallvehicle();
		return new ResponseEntity<List<Vehicle>>(vehicle,HttpStatus.FOUND);
	}
	
	
	@PutMapping("/admin/vehicle/{id}")
	public ResponseEntity<Vehicle> updateVehicle(int id,@RequestBody Vehicle v)
	{
		Vehicle vehicle=service.updateVehicle(id, v);
		return new ResponseEntity<Vehicle>(vehicle,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/admin/vehicle/delete/{id}")
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable("id")int id)
	{
		Vehicle deleteVehicle = service.deleteVehicle(id);
		return new ResponseEntity<Vehicle> (deleteVehicle,HttpStatus.GONE);
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome user";
	}
	
}
