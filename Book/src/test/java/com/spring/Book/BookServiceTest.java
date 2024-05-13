package com.spring.Book;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.spring.Book.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.spring.Book.bean.Book;
import com.spring.Book.repository.BookRepository;

public class BookServiceTest {

    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testInsertBook() {
        Book book = new Book();
        when(bookRepository.save(book)).thenReturn(book);

        Book savedBook = bookService.insertBook(book);

        assertNotNull(savedBook);
        assertEquals(book, savedBook);
        verify(bookRepository).save(book);
    }

    @Test
    public void testGetBook() {
        Book book = new Book();
        when(bookRepository.findById(1)).thenReturn(Optional.of(book));

        Book retrievedBook = bookService.getBook(1);

        assertNotNull(retrievedBook);
        assertEquals(book, retrievedBook);
        verify(bookRepository).findById(1);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> books = new ArrayList<>();
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> retrievedBooks = bookService.getAllBooks();

        assertNotNull(retrievedBooks);
        assertEquals(books, retrievedBooks);
        verify(bookRepository).findAll();
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book();
        when(bookRepository.existsById(1)).thenReturn(true);
        when(bookRepository.findById(1)).thenReturn(Optional.of(book));

        Book deletedBook = bookService.deleteBook(1);

        assertNotNull(deletedBook);
        assertEquals(book, deletedBook);
        verify(bookRepository).deleteById(1);
    }

    @Test
    public void testDeleteNonExistingBook() {
        when(bookRepository.existsById(1)).thenReturn(false);

        Book deletedBook = bookService.deleteBook(1);

        assertNull(deletedBook);
        verify(bookRepository, never()).deleteById(1);
    }

    @Test
    public void testGetAllBooksPaginated() {
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        Page<Book> page = new PageImpl<>(books);
        PageRequest pageRequest = PageRequest.of(0, 10);
        when(bookRepository.findAll(pageRequest)).thenReturn(page);

        Page<Book> retrievedPage = bookService.getAllBooks(0, 10);

        assertNotNull(retrievedPage);
        assertEquals(page, retrievedPage);
        verify(bookRepository).findAll(pageRequest);
    }

    // Add more test cases as needed
}
