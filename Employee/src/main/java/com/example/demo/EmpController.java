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
        return new Employee("Kanhaiya Uike","989391635",new Date());
	}
	
	@GetMapping("/getEmp1")
	public Employee getEMp1() {
        return new Employee("Savita","9479118837",new Date());
	}
	
}
