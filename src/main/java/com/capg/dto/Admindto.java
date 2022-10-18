package com.capg.dto;

import com.capg.entity.User1;

public class Admindto {

	private int AdminId;
	private String password;
	private User1 user1;
	public int getAdminId() {
		return AdminId;
	}
	public String getPassword() {
		return password;
	}
	public User1 getUser1() {
		return user1;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUser1(User1 user1) {
		this.user1 = user1;
	}
	@Override
	public String toString() {
		return "Admindto [AdminId=" + AdminId + ", password=" + password + ", user1=" + user1 + "]";
	}
	
	
}
