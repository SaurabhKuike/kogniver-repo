package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.bean.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/getproduct/{id}")
	public ResponseEntity<Product> getProductbyId(@PathVariable("id") int id) {
		Product productbyId = service.getProductbyId(id);
		return new ResponseEntity<Product>(productbyId, HttpStatus.FOUND);
	}
	@GetMapping("/getproduct")
	public ResponseEntity<List<Product>> getallProduct() {
		List<Product> allProduct = service.getAllProduct();
		return new ResponseEntity<List<Product>>(allProduct, HttpStatus.FOUND);
	}

	@PostMapping
	public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
		Product insertProduct = service.insertProduct(product);
		return new ResponseEntity<Product>(insertProduct, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<Product> deleteProductbyId(@PathVariable("id") int id) {
		service.deleteProductbyId(id);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
	
	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id")int id,@RequestBody Product p)
	{
		Product updateProduct = service.updateProduct(p, id);
		return new ResponseEntity<Product>(updateProduct,HttpStatus.CREATED);
	}
	
	@GetMapping("getproductbyname/{name}")
	public ResponseEntity<Product> getProductbyName(@PathVariable("name")String name){
		Product productbyName = service.findProductbyName(name);
		System.out.println(productbyName);
		return new ResponseEntity<Product>(productbyName,HttpStatus.FOUND);
	}
}