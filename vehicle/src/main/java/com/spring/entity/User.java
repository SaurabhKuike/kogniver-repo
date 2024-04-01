package com.spring.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class for registering a User
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int user_id;
	@NotNull
	@Size(min = 3 ,max = 20, message = "Username can not be fewer than 3 letters and not more than 20 letters")
	private String username;
	@NotNull
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Size(min = 5 ,message = "password must be at least 5 characters long")
	private String password;
	
	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns=@JoinColumn(name="user",referencedColumnName = "user_id"),
	inverseJoinColumns = @JoinColumn(name="role"))
	private List<Roles> roles;

	
}
