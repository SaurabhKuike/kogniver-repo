package com.spring.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.food.Service.FoodService;
import com.spring.food.bean.Food;

@RestController
public class FoodController {
	@Autowired
	private FoodService service;
	
	@PostMapping("/insertfood")
	public ResponseEntity<Food> insertFood(@RequestBody Food f)
	{
		Food insertFood = service.insertFood(f);
		return new ResponseEntity<Food>(insertFood,HttpStatus.CREATED);
	}
	
	@GetMapping("/getfood/{id}")
	public ResponseEntity<Food> getFood(@PathVariable("id") int id )
	{
		Food getfood = service.getfood(id);
		return new ResponseEntity<Food>(getfood,HttpStatus.FOUND);
	}
	
	@GetMapping("/getfood")
	public ResponseEntity<List<Food>> getallFood()
	{
		List<Food>list = service.getallfood();
		System.out.println("stop here");
		return new ResponseEntity<>(list,HttpStatus.FOUND);
	}
	
	@GetMapping("/getallfoodsort")
    public Page<Food> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "food_id") String sortBy) {
        return service.getAllFood(page, size, sortBy);
    }
	
	@PutMapping("/updatefood/{id}")
	public ResponseEntity<Food> updatefood(@PathVariable("id")int id,@RequestBody Food food)
	{
		Food updateFood = service.updateFood(id, food);
		return new ResponseEntity<>(updateFood,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deletefood/{id}")
	public ResponseEntity<Food> deleteFood(@PathVariable("id")int id)
	{
		Food deleteFood = service.deleteFood(id);
		return new ResponseEntity<Food>(deleteFood,HttpStatus.GONE);
	}
}
