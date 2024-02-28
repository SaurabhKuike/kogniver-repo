package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.bean.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public Product getProductbyId(int id) {
		Optional<Product> byId = repo.findById(id);
		return byId.get();
	}
	
	public List<Product> getAllProduct(){
		return repo.findAll();
	}
	
	public Product insertProduct(Product product) {
		return repo.save(product);	
	}
	
	public Product updateProduct(Product p,int id) {
		Product  product = repo.findById(id).get();
		if(product!=null) {
			product.setName(p.getName());
			product.setDescription(p.getDescription());
			product.setPrice(p.getPrice());
			product.setStock(p.getStock());
			repo.save(product);
			return product;
		}
		return null;
	}
	
	public void deleteProductbyId(int id) {
		repo.deleteById(id);
	}
	
	public Product findProductbyName(String name){
		Product productbyName = repo.findProductbyName(name);
		return productbyName;
	}
}
