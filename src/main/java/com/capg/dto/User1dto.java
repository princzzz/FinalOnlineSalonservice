package com.capg.dto;

public class User1dto {

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
