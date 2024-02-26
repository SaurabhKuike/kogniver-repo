package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/getEmp")
	public Employee getEMp() {
		return new Employee("Saurabh", "232323498");
	}
	
	@GetMapping("/getEmp1")
	public Employee getEMp1() {
		return new Employee("Amlan", "232323498");
	}
	
}
