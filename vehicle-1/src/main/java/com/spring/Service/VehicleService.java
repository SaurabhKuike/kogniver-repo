package com.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Vehicle;
import com.spring.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository repo;
	
	public Vehicle insertVehicle(Vehicle v)
	{
		Vehicle save = repo.save(v);
		return save;
	}
	
	public Vehicle getVehicle(int id)
	{
		Vehicle v=repo.findById(id).get();
		return v;
	}
	
	public List<Vehicle> getallvehicle()
	{
		List<Vehicle> all = repo.findAll();
		return all;
	}
	
	public Vehicle updateVehicle(int id,Vehicle v)
	{
		if(repo.existsById(id)) {
			Vehicle vehicle=repo.findById(id).get();
			vehicle.setEngine_type(v.getEngine_type());
			vehicle.setMakedate(v.getMakedate());
			vehicle.setVehicle_name(v.getVehicle_name());
			return vehicle;
		}
		return null;
	}
	
	public Vehicle deleteVehicle(int id)
	{
		Vehicle vehicle = repo.findById(id).get();
		repo.deleteById(id);
		return vehicle;
	}
}
