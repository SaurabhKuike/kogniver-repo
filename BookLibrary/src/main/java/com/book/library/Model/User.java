package com.book.library.Model;

import org.springframework.stereotype.Component;

@Component
public class User {

	
	public User(int userid, String username) {
		super();
		this.userid = userid;
		this.username = username;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + "]";
	}
	private int userid;
	public User(int userid) {
		super();
		this.userid = userid;
	}
	private String username;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
