package com.customer.details.Controller;

import java.util.List;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.details.Service.CustomerService;
import com.customer.details.model.Customer;

@RestController
@RequestMapping("/cust_details")
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	@PostMapping
	public ResponseEntity<Customer> insertCustomerDetails(@RequestBody Customer customer) { 
		
		Customer insertCustomer = service.insertCustomer(customer);
		return new ResponseEntity<>(insertCustomer,HttpStatus.CREATED);
	}
	
	@GetMapping("/getcust/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id)
	{
		Customer customerbyId = service.getCustomerbyId(id);
		return new ResponseEntity<>(customerbyId,HttpStatus.OK);
	}
	
	@GetMapping("/getcust")
	public ResponseEntity<List<Customer>> getallcustomerDetails(){
		List<Customer> allCustomerDetails = service.getAllCustomerDetails();
		return new ResponseEntity<>(allCustomerDetails,HttpStatus.OK);
	}
	
	@PutMapping("/update_cust/{id}")
	public ResponseEntity<Customer> updateCustomerDetials(@RequestBody Customer customer,@PathVariable("id") int id){
		Customer updateCustomerDetails = service.updateCustomerDetails(id, customer);
		return new ResponseEntity<>(updateCustomerDetails,HttpStatus.OK);
	}
	@DeleteMapping("/delete_cust/{id}")
	public String deleteCustomerDetails(@PathVariable("id")int id) {
		service.deleteCustomerDetails(id);
		return "customer details deleted";
	}
	
	@GetMapping("/getcustbyemail/{email}")
	public ResponseEntity<Customer> getCustomerbyEmail(@PathVariable ("email")String email ){
		
		Customer findbyEmail = service.findbyEmail(email);
		return new ResponseEntity<>(findbyEmail,HttpStatus.FOUND);
	}
	
	@GetMapping("/getcustbyadd/{address}")
	public ResponseEntity<List<Customer>> getAllCustomerByAddress(@PathVariable("address")String address){
		List<Customer> allCustomerDetails = service.findAllCustomerByAddress(address);
		return new ResponseEntity<>(allCustomerDetails,HttpStatus.OK);
	}
	
	@GetMapping("/getcustbyName/{name}")
	public ResponseEntity<Customer> getCustomerbyName(@PathVariable("name")String name){
		Customer allCustomerDetails = service.findByName(name);
		if(allCustomerDetails!=null)
		return new ResponseEntity<>(allCustomerDetails,HttpStatus.FOUND);
		else {
			
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
}
