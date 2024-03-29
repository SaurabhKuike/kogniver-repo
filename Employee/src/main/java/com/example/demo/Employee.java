package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Employee {
	
	private String name;
	private String phone;
	private Date date;

	public Employee(String name, String phone, Date date) {
		super();
		this.name = name;
		this.phone = phone;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", phone=" + phone + ", date=" + date + "]";
	}
	
	
}
