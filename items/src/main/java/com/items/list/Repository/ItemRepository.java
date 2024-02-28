package com.items.list.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.items.list.bean.Items;

@Repository
public interface ItemRepository extends MongoRepository<Items, Integer>{

}
