package com.example.demo;

import java.util.Date;

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
		Employee e=new Employee("Saurabh","9893916735",new Date());
		return e;
	}
	
	@GetMapping("/getEmp1")
	public Employee getEMp1() {
		Employee e=new Employee("Savita","9479118837",new Date());
		return e;
	}
	
}
