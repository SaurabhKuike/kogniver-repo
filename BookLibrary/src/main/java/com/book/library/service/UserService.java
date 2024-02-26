package com.book.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.book.library.Model.User;
import com.book.library.repository.UserRepository;

@Service
public class UserService implements UserRepository {

	private static List<User> userList=new ArrayList<>();
	
	static {
		 userList.add(new User(1, "John"));
	        userList.add(new User(2, "Alice"));
	        userList.add(new User(3, "Bob"));
	        userList.add(new User(4,"Saurabh"));
	        userList.add(new User(5, "Karan"));
	        userList.add(new User(6, "Josh"));
	}
	
	public User getUser(int id) {
		
		for(User u:userList)
		{
			if(u.getUserid()==id)
			{
				return u;
			}
		}
		return null;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userList;
	}
	
	public Boolean adduser(User u)
	{
		boolean b = userList.add(u);
		return b;
	}
}
