package com.customer.details.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.details.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer>{

	
	public Customer findByEmail(String email);
	
	@Query("{ 'cust_address' : ?0 }")
    List<Customer> findByCustAddress(String custAddress);
	
	@Query("{'cust_name' : ?0 }")
	Customer findByCustName(String custName);
}
