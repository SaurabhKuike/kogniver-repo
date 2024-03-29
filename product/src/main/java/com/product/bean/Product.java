package com.product.bean;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.ToString;


@Setter
@Getter
@Document(collection="product")
@ToString
public class Product {
	
	@Id
	private Long id;

	private String name;
	private String description;
	private BigDecimal price;
	private Integer stock;
}
