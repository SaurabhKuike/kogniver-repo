package com.spring.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.spring.Dto.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.entity.Vehicle;
import com.spring.repository.VehicleRepository;

/**
 * Vehicle Service class containing all crud operations for Vehicles
 */
public class VehicleService {
	/**
	 * This object is user to perform all curd operations of vehicle entity class
	 */
	private VehicleRepository vehiclerepo;

	VehicleService(){}

	/**
	 * Autowiring the Vehicle Repository object
	 * @param vehiclerepo takes in vehicle repository object
	 */
	@Autowired
	VehicleService(VehicleRepository vehiclerepo)
	{
		this.vehiclerepo=vehiclerepo;
	}

	/**
	 * this method is to save Vehicle Obejct
	 * @param vehicle vehicle object to save into database
	 * @return Vehicle object
	 */
	public Vehicle insertVehicle(Vehicle vehicle)
	{
        return vehiclerepo.save(vehicle);
	}

	/**
	 * Method to get a vehicle by id
	 * @param id takes in one parameter to check if a vehicle exists with this id
	 * @return return the vehicle object if found
	 * @throws NoSuchElementException if no vehicle with given id is found
	 */
	public Vehicle getVehicle(int id)
	{
		//this method checks if Vehicle object with this id exists
		Optional<Vehicle>vehicleOptional=vehiclerepo.findById(id);
		if(vehicleOptional.isPresent())
		{
            return vehicleOptional.get();
		}
		throw new ResourceNotFoundException("id","VehicleID",id+"");
	}

	/**
	 * this method return all vehicle Object
	 * @return returns List of all vehicle Objects
	 */
	public List<Vehicle> getallVehicle()
	{
		return vehiclerepo.findAll();
	}

	/**
	 * Method to delete a Vehicle using Vehicle object
	 * @param id takes in one parameter int id to check if vehicle with this id exists
	 * @return return vehicle object if found
	 * @throws NoSuchElementException if no vehicle with this id is found
	 */
	public Vehicle deleteVehicle(int id)
	{
		Optional<Vehicle>vehicleOptional=vehiclerepo.findById(id);
		if(vehicleOptional.isPresent())
		{
			Vehicle vehicle= vehicleOptional.get();
			vehiclerepo.delete(vehicle);
			return vehicle;
		}
		throw new ResourceNotFoundException("ID","Vehicle ID",id+"");
	}

	/**
	 *this method is to update Vehicle object if exists
	 * @param id Id  parameter is used to check if Vehicle with this id exists of not
	 * @param vehicle Takes in one vehicle object that Contains all updated values to be set into existing object
	 * @return returns update vehicle object
	 * @throws NoSuchElementException if no vehicle with this id exists
	 */
	public Vehicle updateVehicle(int id,Vehicle vehicle)
	{
		Optional<Vehicle>vehicleOptional=vehiclerepo.findById(id);
		if(vehicleOptional.isPresent()) {
			Vehicle vehicle2=vehicleOptional.get();
			vehicle2.setEngine_type(vehicle.getEngine_type());
			vehicle2.setMakedate(vehicle.getMakedate());
			vehicle2.setVehicle_name(vehicle.getVehicle_name());
			return vehicle2;
		}
		throw new ResourceNotFoundException("Id","Vehicle ID",id+"");
	}
}
