package com.book.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.book.library.Model.Book;
import com.book.library.repository.BookRepository;

@Service
public class BookService implements BookRepository{

	private static List<Book> books=new ArrayList<>();
	static {
		books.add(new Book("To Kill a Mockingbird", 1, "Harper Lee"));
        books.add(new Book("1984", 2, "George Orwell"));
        books.add(new Book("The Great Gatsby", 3, "F. Scott Fitzgerald"));
        books.add(new Book("Pride and Prejudice", 4, "Jane Austen"));
        books.add(new Book("The Catcher in the Rye", 5, "J.D. Salinger"));
        books.add(new Book("The Hobbit",6, "J.R.R. Tolkien"));
        books.add(new Book("The Lord of the Rings", 7, "J.R.R. Tolkien"));
	}
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return books;
	}

	@Override
	public Book getBook(int id) {
		for(Book b: books)
		{
			if(b.getBid()==id)
			{
				return b;
			}
		}
		return null;
	}
	
	public boolean addBook(Book b)
	{
		if(books.add(b))
		{
			return true;
		}
		return false;
	}

}
