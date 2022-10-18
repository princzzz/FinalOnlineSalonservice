package com.capg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Admin {
    @Id
	private int AdminId;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user1Id")
	private User1 user1;
	public Admin(int adminId, String password, User1 user1) {
		super();
		AdminId = adminId;
		this.password = password;
		this.user1 = user1;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User1 getUser1() {
		return user1;
	}
	public void setUser1(User1 user1) {
		this.user1 = user1;
	}
	@Override
	public String toString() {
		return "Admin [AdminId=" + AdminId + ", UserId=" +", password=" + password + ", user1=" + user1 + "]";
	}
	
	
}
