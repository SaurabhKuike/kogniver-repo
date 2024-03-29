package com.spring.service;



import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.entity.User;


/**
 * Implementing class of UserDetails which contain all details of a User
 */
public class CustomUserDetail implements UserDetails {
	/**
	 * User class object to set all info about user and save it in database
	 */
	private User user;

	/**
	 *
	 * @param user takes one input as User object and set it with a user object
	 */
	public CustomUserDetail(User user) {
		this.user = user;
	}

	/**
	 * Method to provide authority to a user based on role
	 * @return returns a collection of Granted Authority object
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<SimpleGrantedAuthority> collect = user.getRoles().stream().map((role)->new SimpleGrantedAuthority(role.getRolename())).collect(Collectors.toList());
		return collect;
	}

	/**
	 * setter method for Name of user
	 * @return full name
	 */
	public String getFullname() {
		return user.getUsername();
	}

	/**
	 *
	 * @return returns password of user
	 */
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	/**
	 *
	 * @return returns username of user
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	/**
	 *
	 * configuration of User
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 *
	 * configuration of User
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 *
	 * configuration of User
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 *
	 * configuration of User
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}