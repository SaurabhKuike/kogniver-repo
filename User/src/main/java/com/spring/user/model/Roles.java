package com.spring.user.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Roles {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleid;
	private String rolename;
	
	@ManyToMany
	private List<User> user;
}
