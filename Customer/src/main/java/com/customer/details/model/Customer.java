package com.customer.details.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

	private String cust_name;
	private String cust_address;
	private String email;
	private String gender;
}
