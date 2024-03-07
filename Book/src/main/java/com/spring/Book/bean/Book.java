package com.spring.Book.bean;


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
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bId;
	@Column(unique = true,length = 30)
	private String title;
	@Column(nullable = true)
	private String author;
	private int pages;
	@Override
	public String toString() {
		return "Book [bId=" + bId + ", title=" + title + ", author=" + author + ", pages=" + pages + "]";
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	
}
