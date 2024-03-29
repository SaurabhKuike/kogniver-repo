package com.spring.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

/**
 * Controller having role based endpoints
 * for accessing vehicle and user data
 */
@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "vehicle")
public class RoleController {



	/**
	 * User service implementation class object
	 */
	private UserServiceImpl service;

	/**
	 * Vehicle Repository Interface object
	 */
	private VehicleRepository repo;

	/**
	 * private RoleController constructor for constructor injection
	 * @param repo VehicleRepository Object to initialize the VehicleRepository object
	 * @param service UserServiceImpl Object to initialize the UserServiceImpl object
	 */
	@Autowired
	private RoleController(VehicleRepository repo,UserServiceImpl service){
		this.repo=repo;
		this.service=service;
	}
	RoleController(){

	}
	/**
	 *method to return all vehicle from database
	 * @return ResponseEntity with message found all vehicle and httpStatus Found with status code 302
	 */
	@GetMapping("/user/getallvehicle")
	public ResponseEntity<Object> getallvehicle() {
		List<Vehicle> all = repo.findAll();
		return CustomResponseHandler.responsebuilder("Found All Vehicle", HttpStatus.FOUND,all);
	}

	/**
	 *method to get vehicle by passing id
	 * @param id passed while calling this method
	 * @return ResponseEntity object which gives status as 302 found
	 */
	@GetMapping("/user/getvehicle/{id}")
	public ResponseEntity<Object> getvehiclebyid(@PathVariable("id")int id)
	{
		Vehicle vehicle = repo.findById(id).get();
		return CustomResponseHandler.responsebuilder("Found the Vehicle By Id", HttpStatus.FOUND,vehicle);
	}

	/**
	 * Inserts a new vehicle record into the database.
	 *
	 * @param vehicle The Vehicle object to be inserted.
	 *                It should contain the details of the vehicle to be saved.
	 * @return ResponseEntity containing the saved Vehicle object if successful.
	 *         Returns HTTP status 302 (FOUND) indicating that the resource is found,
	 *         along with the saved Vehicle object in the response body.
	 */
	@PostMapping("/admin/vehicle/insert")
	public ResponseEntity<Object> insertVehicle(@RequestBody Vehicle vehicle) {
		Vehicle savedVehicle = repo.save(vehicle);
		return CustomResponseHandler.responsebuilder("Vehicle Inserted", HttpStatus.FOUND, savedVehicle);
	}

	/**
	 *
	 * @param id The id is passed as parameter and finds the USER object with id
	 * @return ResponseEntity with message Found User and Status code 302 and user object
	 */
	@GetMapping("/user/getuser/{id}")
	public ResponseEntity<Object> getuser(@PathVariable("id")int id)
	{
		return CustomResponseHandler.responsebuilder("Found User", HttpStatus.FOUND,service.getUser(id));
	}

	/**
	 * method with authorization admin to get all user
	 * @return ResponseEntity with message found all user and HttpStatus Found and code 302
	 */
	@GetMapping("/admin/getalluser")
	public ResponseEntity<Object> getalluser()
	{
		 List<User> getalluser = service.getalluser();
		 return CustomResponseHandler.responsebuilder("Found All Users", HttpStatus.FOUND,getalluser);
	}

	/**
	 *
	 * @param id pass id as parameter to find and delete the user with this id
	 * @return ResponseEntity Object with message user deleted and Https status accepted and code 202
	 */
	@DeleteMapping("/admin/deleteuserbyid/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") int id){
		User deleteUser = service.deleteUser(id);
		return CustomResponseHandler.responsebuilder("User Deleted", HttpStatus.ACCEPTED, deleteUser);
	}

	/**
	 * method to delete a user by email
	 * @param email accepts one parameter as string email which user you want to delete
	 * @return returns the same deleted user details
	 */
	@DeleteMapping("/admin/deleteuserbyemail/{email}")
	public ResponseEntity<Object> deleteUserbyEmail(@PathVariable("email") String email)
	{
		User user=service.deleteUserbyEmail(email);
		return CustomResponseHandler.responsebuilder("User Deleted By Email",HttpStatus.ACCEPTED,user);
	}
}