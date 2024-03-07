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
	
	public Items updateItem(int id,Items item)
	{
		Items byId = repo.findById(id).get();
		if(byId!=null) {
			byId.setName(item.getName());;
			byId.setPrice(item.getPrice());
			byId.setStock(item.getStock());
			repo.save(byId);
		}
		return byId;
	}
	
	public Items updateStock(int id,int updateStock)
	{
		Items updateStock2 = repo.updateStock(id, updateStock);
		System.out.println(updateStock2);
		repo.save(updateStock2);
		return updateStock2;
	}
	
}
