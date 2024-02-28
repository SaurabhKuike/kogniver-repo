package com.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.bean.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer>{

	@Query("{ 'name' : ?0 }")
	Product findProductbyName(String name);
}
