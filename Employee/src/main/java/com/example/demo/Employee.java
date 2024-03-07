package com.example.demo;

import java.util.Date;

public class Employee {
	
	private String name;
	private String phone;
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
