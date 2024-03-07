package com.spring.food.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.food.bean.Food;
import com.spring.food.repository.FoodRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FoodService {

	@Autowired
	private FoodRepository repo;
	
	public Food insertFood(Food f)
	{
		log.info("inside insertfood method");
		log.debug("insert food debug");
		Food save = repo.save(f);
		return save;
	}
	
	public Food getfood(int id)
	{
		log.warn("inside getfood");
		Food food = repo.findById(id).get();
		return food;
	}
	
	public List<Food> getallfood(){
		Iterable<Food> all = repo.findAll();
		Iterator<Food> iterator = all.iterator();
		List<Food>list=new ArrayList<>();
		while(iterator.hasNext())
		{
			list.add(iterator.next());
		}
		log.info("returned list of food");
		return list;
		
	}
	
	public Page<Food> getAllFood(int page,int size,String sortBy)
	{
		Pageable pageable= PageRequest.of(page, size, Sort.by(sortBy));
		return repo.findAll(pageable);
	}
	
	public Food updateFood(int id,Food food)
	{
		Food f=repo.findById(id).get();
		if(f==null||food==null)
		{
			throw new NullPointerException();
		}
		f.setDescription(food.getDescription());
		f.setName(food.getName());
		f.setPrice(food.getPrice());
		repo.save(f);
		return f;
	}
	
	public Food deleteFood(int id)
	{
		log.info("deleting food with id:"+id);
		Food f=repo.findById(id).get();
		if(f==null) {
			throw new NullPointerException();
		}
		repo.deleteById(id);
		return f;
	}
	
}
