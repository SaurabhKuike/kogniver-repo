package com.book.library.Model;

import org.springframework.stereotype.Component;

@Component
public class Book {

	private String title;
	private int bid;
	private String author;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String title, int bid, String author) {
		super();
		this.title = title;
		this.bid = bid;
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", bid=" + bid + ", author=" + author + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
