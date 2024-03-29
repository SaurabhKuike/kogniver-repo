package com.customer.details.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.details.Repository.CustomerRepository;
import com.customer.details.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	public Customer insertCustomer(Customer customer) {
		Customer save = repo.save(customer);
		return save;
	}
	
	public Customer getCustomerbyId(int id) {
		Optional<Customer> byId = repo.findById(id);
		return byId.get();
	}
	
	public List<Customer> getAllCustomerDetails(){
		List<Customer> all = repo.findAll();
		return all;
	}
	
	public Customer updateCustomerDetails(int cust_id,Customer customer)
	{
		Customer byId = repo.findById(cust_id).get();
		
		if(byId!=null)
		{
			byId.setCust_address(customer.getCust_address());
			byId.setCust_name(customer.getCust_name());
			byId.setEmail(customer.getEmail());
			byId.setGender(customer.getGender());
			repo.save(byId);
			return byId;
		}
		
		return null;
	}
	
	public void deleteCustomerDetails(int cust_id)
	{
		repo.deleteById(cust_id);
	}
	
	
	
	public List<Customer> findAllCustomerByAddress(String address)
	{
		List<Customer> byCustAddress = repo.findByCustAddress(address);
		return byCustAddress;
	}
	
	public Customer findByName(String name) {
		Customer cust = repo.findByCustName(name);
		return cust;
	}
	
	public Customer findbyEmail(String email)
	{
		Customer cust=repo.findByCustEmail(email);
		return cust;
	}
}
