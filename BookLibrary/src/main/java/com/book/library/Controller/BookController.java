package com.book.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.library.Model.Book;
import com.book.library.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping("/getbook/{id}")
	public ResponseEntity<Book> getBookByid(@PathVariable("id")int id){
		
		return new ResponseEntity<>(service.getBook(id),HttpStatus.FOUND);
	}
	@GetMapping("/getbook")
	public ResponseEntity<List<Book>> getAllBOoks(){
		
		return new ResponseEntity<>(service.getAllBooks(),HttpStatus.FOUND);
	}
	
	@PostMapping("/addbook/{id}")
	public ResponseEntity<Book> addBook(@RequestBody Book b,@PathVariable("id")int id)
	{
		System.out.println(b);
		boolean book = service.addBook(b);
		if(book)
		{
			return new ResponseEntity<Book>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Book>(HttpStatus.NOT_ACCEPTABLE);
	}
	
}
