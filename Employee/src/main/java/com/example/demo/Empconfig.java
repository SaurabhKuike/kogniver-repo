package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class Empconfig {

	private static ObjectMapper customobjectmapper;
	@Bean
	ObjectMapper getobjectmapper() {
		customobjectmapper=new ObjectMapper();
		customobjectmapper.setDateFormat(new SimpleDateFormat("dd-MM-YYYY  hh-mm"));
		try {
			System.out.println(customobjectmapper.writeValueAsString(new Employee("sonam", "232424", new Date())));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customobjectmapper;
	}
}
