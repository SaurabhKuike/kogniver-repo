package com.customer.details.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.details.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer>{

	
	public Customer findByEmail(String email);
	
	@Query(value="{ 'cust_address' : ?0 }")
    List<Customer> findByCustAddress(String custAddress);
	
	@Query(value="{'cust_name' : ?0 }", fields="{'cust_address':0,'email':0}")
	Customer findByCustName(String custName);
	
	@Query(value="{ 'email': ?0, 'cust_address': { $exists: true } }", fields="{ 'cust_name': 1, 'gender': 1 }")
	Customer findByCustEmail(String email);

}
