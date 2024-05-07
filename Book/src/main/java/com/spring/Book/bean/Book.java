package com.spring.Book.bean;


import lombok.*;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Component
@Entity
@Table(name="Books_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bId;
	@Column(unique = true,length = 30)
	private String title;
	@Column(nullable = true)
	private String author;
	private int pages;

}
