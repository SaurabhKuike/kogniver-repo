package com.spring.food.configure;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@Configuration
@ComponentScan
public class FoodConfiguration {

	@SuppressWarnings("deprecation")
	@Bean
	 ObjectMapper getMapper() {
		ObjectMapper objectmapper=new ObjectMapper();
		objectmapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
		objectmapper.setDateFormat(new SimpleDateFormat("dd-YYYY-MM"));
		return new ObjectMapper();
	}
}
