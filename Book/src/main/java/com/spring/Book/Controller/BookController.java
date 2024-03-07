package com.spring.Book.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Book.bean.Book;
import com.spring.Book.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService service;
	
	@PostMapping("/insertbook")
	public ResponseEntity<Book> insertBook(@RequestBody Book book)
	{
		Book insertBook = service.insertBook(book);
		return new ResponseEntity<Book>(insertBook,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getbook/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id")int id)
	{
		Book book = service.getBook(id);
		return new ResponseEntity<Book>(book,HttpStatus.FOUND);
	}
	
	@GetMapping("/getallbooks")
	public ResponseEntity<List<Book>> getallbooks(){
		List<Book> allBooks = service.getAllBooks();
		return new ResponseEntity<List<Book>>(allBooks,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deletebook/{id}")
	public ResponseEntity<String> deletebook(@PathVariable("id")int id){
		String deleteBook = service.deleteBook(id);
		return new ResponseEntity<String>(deleteBook,HttpStatus.GONE);
	}
	
	
}