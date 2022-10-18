package com.capg.dto;

import javax.validation.constraints.NotNull;

public class User1dto {

	@NotNull(message = "Please provide valid user1Id")
	private String user1Id;
	private String password;
	public String getUser1Id() {
		return user1Id;
	}
	public String getPassword() {
		return password;
	}
	public void setUser1Id(String user1Id) {
		this.user1Id = user1Id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User1dto [user1Id=" + user1Id + ", password=" + password + "]";
	}
	
	
}
