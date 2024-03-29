package com.spring.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles {
	public Roles(int i, String string) {
		roleid=i;
		string=rolename;
		
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleid;
	private String rolename;
	
	@JsonIgnore
	 @ManyToMany(mappedBy = "roles")
	private List<User> user;
}
