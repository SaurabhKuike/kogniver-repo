package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.bean.Product;
import com.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public Product getProductbyId(int id) {
		Optional<Product> byId = repo.findById(id);
		log.debug("get product by id");
		return byId.get();
	}
	
	public List<Product> getAllProduct(){
		log.debug("get all products");
		return repo.findAll();
	}
	
	public Product insertProduct(Product product) {
		log.debug("insert product");
		return repo.save(product);	
	}
	
	public Product updateProduct(Product p,int id) {
		log.debug("update product");
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
		log.debug("delete");
		repo.deleteById(id);
	}
	
	public Product findProductbyName(String name){
		Product productbyName = repo.findProductbyName(name);
		return productbyName;
	}
}
