package com.spring.food.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring.food.bean.Food;

@Repository
public interface FoodRepository extends PagingAndSortingRepository<Food, Integer> , CrudRepository<Food, Integer>{

}
