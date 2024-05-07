package com.spring.Book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.Book.bean.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer>, JpaRepository<Book,Integer> {
    Page<Book> findAll(Pageable pageable);
}
