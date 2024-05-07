package com.spring.Book.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.Book.bean.Book;
import com.spring.Book.service.BookService;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestController
@RequestMapping("/api")
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
	public ResponseEntity<Book> deletebook(@PathVariable("id")int id){
		 Book book= service.deleteBook(id);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}

	@GetMapping("/getbookex")
	public ResponseEntity<Book> getbooksex()
	{
		if(false)
		return new ResponseEntity<Book>(HttpStatus.FOUND);


		else throw new RuntimeException();
	}
	/*@GetMapping("/getbooks/{page}/{size}")
	public ResponseEntity<Page<Book>>  pagingBook(@PathVariable("page")int page,@PathVariable("size")int size){
		Page<Book> allBooks = service.getAllBooks(page, size);
		return new ResponseEntity<>(allBooks,HttpStatus.OK);
	}*/
	
}