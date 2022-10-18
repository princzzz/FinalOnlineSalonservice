package com.capg.entity;
import javax.persistence.*;

@Entity
public class User1 {
	@Id
	private String user1Id;
	private String password;
	
	public User1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User1(String userId, String password) {
		super();
		this.user1Id = userId;
		this.password = password;
	}
	
	public String getUserId() {
		return user1Id;
	}
	public void setUserId(String userId) {
		this.user1Id = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "User [userId=" + user1Id + ", password=" + password + "]";
	}
	
}
