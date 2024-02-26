package com.book.library.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.book.library.Model.User;

@Repository
public interface UserRepository {

	List<User> getAllUser();
	User getUser(int id);
}
