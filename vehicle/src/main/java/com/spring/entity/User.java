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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	private String username;
	private String email;
	private String password;
	
	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns=@JoinColumn(name="user",referencedColumnName = "user_id"),
	inverseJoinColumns = @JoinColumn(name="role"))
	private List<Roles> roles;

	
}
