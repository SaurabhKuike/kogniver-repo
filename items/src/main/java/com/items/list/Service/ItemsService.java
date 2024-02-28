package com.items.list.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.items.list.Repository.ItemRepository;
import com.items.list.bean.Items;

@Service
public class ItemsService {
	@Autowired
	private ItemRepository repo;
	
	public Items insertItem(Items item) {
		return repo.save(item);
	}
	
	public Items getItem(int id) {
		return repo.findById(id).get();
	}
	
	public List<Items> getAllItems(){
		return repo.findAll();
	}
	
	public void deleteItem(int id) {
		repo.deleteById(id);
	}
}
