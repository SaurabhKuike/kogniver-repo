package com.spring.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class for User Role
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles {
	public Roles(int roleid, String rolename) {
		this.roleid=roleid;
		this.rolename=rolename;
		
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private int roleid;
	@NotNull
	@Size(min = 3,message = "Role Name can not be fewer than 4 characters")
	private String rolename;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private List<User> user;
}
