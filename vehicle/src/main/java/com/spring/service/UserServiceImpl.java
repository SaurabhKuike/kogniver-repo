package com.spring.service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.spring.Dto.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.Dto.UserDto;
import com.spring.entity.User;
import com.spring.repository.UserRepository;


/**
 * UserService implementation class
 */
@Service
public class UserServiceImpl implements UserService{

	/**
	 * password Encoder Object for saving the password of user encrypted
	 */
	private PasswordEncoder passwordencoder;

	/**
	 * UserRepository object to perform CRUD operation
	 */
	private UserRepository repo;
	UserServiceImpl(){

	}

	/**
	 *
	 * @param passwordencoder constructor injection to password encoder object
	 * @param repo constructor injection to UserRepository object
	 */
	@Autowired
	private UserServiceImpl(PasswordEncoder passwordencoder,UserRepository repo){
		this.passwordencoder=passwordencoder;
		this.repo=repo;
	}

	/**
	 * method to return all user Objects
	 * @return return List of all users
	 */
	public List<User> getalluser(){
		//returning all the User objects from data base
		return repo.findAll();
	}

	/**
	 * method to return a user by searching it with its id
	 * @param id takes in one parameter id to search an User object with id
	 * @return return the user object if found
	 * @throws NoSuchElementException is thrown if no user with this id is found
	 */
	public User getUser(int id)
	{
		//
		Optional<User>optionalUser=repo.findById(id);
		if(optionalUser.isPresent())
		{
            return optionalUser.get();
		}
		throw new ResourceNotFoundException("user","UserId",id+"");
	}

	/**
	 * THis method is used to save a User
	 * @param user Takes in a UserDto object as parameter to set the values of User Object
	 * @return returns a User Object to show all the details to user
	 */
	public User save(UserDto user)
	{// Taking a User DTO object as parameter having all the fields of User entity class
		// Creating a new User object and using setter methods of User class
		// and getter method of User DTO class we are setting all values
		// then Using User Repository save method we are saving the data in database
		User u=new User();
		u.setEmail(user.getEmail());
		u.setRoles(user.getRole());
		u.setUsername(user.getFullname());
		u.setUser_id(user.getId());
		u.setPassword(passwordencoder.encode(user.getPassword()));
		repo.save(u);
		return u;
	}

	/**
	 * Method to delete a User by id
	 * @param id Takes a parameter Integer id which is used to find the User Object
	 * @return returns the deleted user object
	 * @throws NoSuchElementException if no user with given id is found
	 */
	public User deleteUser(int id)
	{
		/*
		using id to search a User Object with user repository object with method findbyid
		using if condition to check if returned Optional object contains user object If contains
		user object then return it otherwise throw NoSuchElementException
		 */
		Optional<User> user= repo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		throw new ResourceNotFoundException("User","UserId",id+"");
	}

	/**
	 * Method to delete a user by Email
	 * @param email takes a String Email
	 * @return return the deleted user Object
	 * @throws NoSuchElementException if no User with given email is found then this exception is thrown
	 */
	public User deleteUserbyEmail(String email){
		//This method takes in one parameter String email and Using UserRepository object
		//we find the User Object by findbyEmail method
		//then validate if user is present then we return the object otherwise
		//throw no such element exception
		Optional<User>userOptional=repo.findByEmail(email);
		if(userOptional.isPresent()){
			repo.delete(userOptional.get());
            return userOptional.get();
		}
		throw new ResourceNotFoundException("User","email",email);
	}
}