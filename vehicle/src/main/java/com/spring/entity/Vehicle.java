package com.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * Entity Class for saving A Vehicle Object
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int v_id;
	@NotBlank
	@Length(max = 20,min = 3, message = "Vehicle Name must be between 3 and 20 characters long")
	private String vehicle_name;
	@NotBlank
	@Length(min = 6 ,max = 10)
	private String makedate;
	@NotBlank
	@Length(min = 3,max = 20, message = "engine type must be between 3 and 20 characters long")
	private String engine_type;
}
