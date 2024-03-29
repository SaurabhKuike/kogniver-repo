package com.spring.Dto;
import java.util.List;

import com.spring.entity.Roles;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
	
	private String email;
	private String password;
	private List<Roles> role;
	private String fullname;
	private int id;
	
	public UserDto(String email, String password, List<Roles> role, String fullname,int id) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.fullname = fullname;
		this.id=id;
	}

	
	
	

}