package com.spring.Book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.Book.bean.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer>{

}
