package com.spring.food.bean;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Food_Table")
public class Food {

	public Food() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int food_id;
	private String name;
	private double price;
	@Override
	public int hashCode() {
		return Objects.hash(description, food_id, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		return Objects.equals(description, other.description) && food_id == other.food_id
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	@Override
	public String toString() {
		return "Food [food_id=" + food_id + ", name=" + name + ", price=" + price + ", description=" + description
				+ "]";
	}
	private String description;
	public int getFood_id() {
		return food_id;
	}
	public Food(int food_id, String name, double price, String description) {
		super();
		this.food_id = food_id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
