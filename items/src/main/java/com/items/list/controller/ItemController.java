package com.items.list.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.items.list.Service.ItemsService;
import com.items.list.bean.Items;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private ItemsService service;
	@PostMapping
	public ResponseEntity<Items> insertItems(@RequestBody Items item) {
		Items insertItem = service.insertItem(item);
		return Optional.ofNullable(insertItem).
				map(i -> ResponseEntity.ok(i)).
				orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/getitem/{id}")
	public ResponseEntity<Items> getItem(@PathVariable("id")int id)
	{
		Items item = service.getItem(id);
		return new ResponseEntity<Items>(item,HttpStatus.OK);
	}
	@GetMapping("/getitems")
	public ResponseEntity<List<Items>> getallItems(){
		List<Items> allItems = service.getAllItems();
		return new ResponseEntity<List<Items>>(allItems,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteitem/{id}")
	public ResponseEntity<Items> deleteItem(@PathVariable("id")int id)
	{
		service.deleteItem(id);
		return new ResponseEntity<Items>(HttpStatus.GONE);
	}
	
	@PutMapping("/updateitem/{id}")
	public ResponseEntity<Items> updateItem(@PathVariable("id")int id,@RequestBody Items item) 
	{
		Items updateItem = service.updateItem(id, item);
		return new ResponseEntity<Items>(updateItem,HttpStatus.CREATED);
	}
	
	@PatchMapping("/updateStock/{id}/{stock}")
	public ResponseEntity<Items>updateStock(@PathVariable("id")int id,@PathVariable("stock")int stock)
	{
		Items updateStock = service.updateStock(id, stock);
		return new ResponseEntity<Items>(updateStock,HttpStatus.CREATED);
	}
}