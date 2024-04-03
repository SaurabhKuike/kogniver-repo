package com.spring.Book.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Book.bean.Book;
import com.spring.Book.repository.BookRepository;
import org.springframework.web.reactive.function.client.WebClient;

@Service

public class BookService {

	@Autowired
	private BookRepository repo;
	
	private WebClient webClient;
	public Book insertBook(Book b)
	{
		Book save = repo.save(b);
		return save;
	}
	
	public Book getBook(int id)
	{
		Book book = repo.findById(id).get();
		return book;
	}
	
	public List<Book> getAllBooks(){
		Iterable<Book> all = repo.findAll();
		Iterator<Book> iterator = all.iterator();
		List<Book>list=new ArrayList<>();
		while(iterator.hasNext()) {
			list.add(iterator.next());
	}
		return list;
}
	public Book deleteBook(int id)
	{
		Book book=null;
		if(repo.existsById(id)) {
			book = repo.findById(id).get();
			repo.deleteById(id);
		return book;
		}
		return book;
	}
}
