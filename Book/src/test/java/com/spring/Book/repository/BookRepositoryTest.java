package com.spring.Book.repository;

import com.spring.Book.bean.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookRepositoryTest {

    @Mock
    private CrudRepository<Book, Integer> crudRepositoryMock;

    @Mock
    private JpaRepository<Book, Integer> jpaRepositoryMock;

    @InjectMocks
    private BookRepository bookRepository;

    public Page<Book> createMockedPage() {
        // Create a list of books (you can customize this list as needed)
        List<Book> books = new ArrayList<>();
        Book book1=new Book();
        Book book2=new Book();
        books.add(book1); // Add book objects with appropriate data
        books.add(book2);

        // Create a mocked Pageable object (you can use mockito for this as well)
        Pageable pageable = mock(Pageable.class);

        // Create a PageImpl object using the list of books and pageable
        return new PageImpl<>(books, pageable, books.size());
    }@Test
    public void testFindAll() {
        // Mock behavior of the methods in CrudRepository and JpaRepository
        // For example, when findAll method is called, return a mocked Page
        Page<Book> mockedPage = createMockedPage();// Create a mocked Page<Book> as needed
        when(jpaRepositoryMock.findAll(any(Pageable.class))).thenReturn(mockedPage);

        // Invoke the method you want to test
        Page<Book> result = bookRepository.findAll(mock(Pageable.class));

        // Assert the result as needed
        // For example, assert that the result matches the mockedPage
    }

    // Add more test cases for other methods if needed
}
