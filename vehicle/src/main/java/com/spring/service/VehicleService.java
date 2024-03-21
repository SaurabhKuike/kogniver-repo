package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.entity.Vehicle;
import com.spring.repository.VehicleRepository;

public class VehicleService {
	@Autowired
	private VehicleRepository vehiclerepo;
	
	public Vehicle insertVehicle(Vehicle v)
	{
		Vehicle save = vehiclerepo.save(v);
		return save;
	}
	
	public Vehicle getVehicle(int id)
	{
		Vehicle vehicle = vehiclerepo.findById(id).get();
		return vehicle;
	}

	public List<Vehicle> getallVehicle()
	{
		return vehiclerepo.findAll();
	}
	
	public Vehicle deleteVehicle(int id)
	{
		Vehicle vehicle = vehiclerepo.findById(id).get();
		vehiclerepo.deleteById(id);
		return vehicle;
	}
	
	public Vehicle updateVehicle(int id,Vehicle vehicle)
	{
		Vehicle vehicle2 = vehiclerepo.findById(id).get();
		vehicle2.setEngine_type(vehicle.getEngine_type());
		vehicle2.setMakedate(vehicle.getMakedate());
		vehicle2.setVehicle_name(vehicle.getVehicle_name());
		return vehicle2;
	}
}
