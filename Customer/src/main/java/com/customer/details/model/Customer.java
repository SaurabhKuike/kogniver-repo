package com.customer.details.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("customer")
public class Customer {

	@Id
	
	private int cust_id;
	@NotEmpty
	@Size(min=5,max=20 ,message="customer name can not be less than 5 letters")
	private String cust_name;
	
	@Size(min=5,max=20,message="customer name can not be less than 5 letters")
	private String cust_address;
	@NotNull
	@Size(min=5,max=20,message="customer name can not be less than 5 letters")
	private String email;
	@NotNull
	@Size(min=5,max=20,message="customer name can not be less than 5 letters")
	private String gender;
}
