package com.items.list.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.items.list.bean.Items;

@Repository
public interface ItemRepository extends MongoRepository<Items, Integer>{

	@Query("{ 'id' : ?0 }")
	Items updateStock(int id, int updateStock);
}
