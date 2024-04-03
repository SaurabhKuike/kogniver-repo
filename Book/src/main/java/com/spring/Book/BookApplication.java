package com.spring.Book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BookApplication {

	@Bean
	public WebClient webclient(){
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

}
