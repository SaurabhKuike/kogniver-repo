package com.book.library.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.book.library.Model.Book;

@Repository
public interface BookRepository {

	List<Book> getAllBooks();
	Book getBook(int id);
	boolean addBook(Book b);
}
