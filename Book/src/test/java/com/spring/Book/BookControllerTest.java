package com.spring.Book;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.spring.Book.Controller.BookController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.Book.bean.Book;
import com.spring.Book.service.BookService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        // Mocking behavior for bookService methods can be defined here if needed
    }

    @Test
    public void testInsertBook() throws Exception {
        Book book = new Book();
        when(bookService.insertBook(book)).thenReturn(book);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/insertbook")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"title\": \"Test Book\" }"))
                .andExpect(status().isAccepted())
                .andReturn();

        // Assert further as needed
    }

    @Test
    public void testGetBook() throws Exception {
        int id = 1;
        Book book = new Book();
        when(bookService.getBook(id)).thenReturn(book);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/getbook/{id}", id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andReturn();

        // Assert further as needed
    }

    @Test
    public void testGetAllBooks() throws Exception {
        List<Book> books = new ArrayList<>();
        when(bookService.getAllBooks()).thenReturn(books);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/getallbooks")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andReturn();

        // Assert further as needed
    }

    @Test
    public void testDeleteBook() throws Exception {
        int id = 1;
        Book book = new Book();
        when(bookService.deleteBook(id)).thenReturn(book);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/api/deletebook/{id}", id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert further as needed
    }

    // Add more test cases as needed
}
