package com.capg.dto;

import java.time.LocalDate;
import com.capg.entity.User1;

public class Customerdto {

	private Integer userId;
	private String name;
	private String email;
	private String contactNo;
	private LocalDate dob;
	private User1 user1;
	public Integer getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public LocalDate getDob() {
		return dob;
	}
	public User1 getUser1() {
		return user1;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public void setUser1(User1 user1) {
		this.user1 = user1;
	}
	@Override
	public String toString() {
		return "Customerdto [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", user1=" + user1 + "]";
	}
	public Customerdto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customerdto(Integer userId, String name, String email, String contactNo, LocalDate dob, User1 user1) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.user1 = user1;
	}
	
	
	
	
	
	
}
