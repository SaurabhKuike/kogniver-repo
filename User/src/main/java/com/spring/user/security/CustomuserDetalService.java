package com.spring.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.user.exception.ResourceNotFoundException;
import com.spring.user.model.User;
import com.spring.user.repository.UserRepository;

@Service
public class CustomuserDetalService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.repo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("user with Email:"+username+" does not exist"));
		
		return new CustomUserDetail(user);
	}

}
