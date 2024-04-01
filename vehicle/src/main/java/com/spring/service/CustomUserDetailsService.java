package com.spring.service;
import com.spring.Dto.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.entity.User;
import com.spring.repository.UserRepository;

import java.util.Optional;

/**
 * This class is used to load a User from Database .
 * This class implements UserDetailsService Interface
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	/**
	 * user repository object to load a user using Username or here as email
	 */
	 private final UserRepository userRepository;

	/**
	 * Constructor to set UserRepository object
	 * @param userRepository this object is use to set
	 */
	@Autowired
	 private CustomUserDetailsService(UserRepository userRepository){
		 this.userRepository=userRepository;
	 }

	/**
	 *
	 * @param username the username identifying the user whose data is required.
	 * @return returns The user if found
	 * @throws UsernameNotFoundException if user is not found in database then This exception this thrown
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(username);

		return user.map(CustomUserDetail::new).orElseThrow(() -> new ResourceNotFoundException("User", "email", username));
	}

}