package com.capg.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.capg.entity.Appointment;
import com.capg.entity.Customer;
import com.capg.entity.User1;

public class Customerdto {

	@NotNull(message = "Please provide valid userId")
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
	
	public static Customerdto entityToDTO(Customer customer2) {
		Customerdto customer3 = new Customerdto();
		customer3.setContactNo(customer2.getContactNo());
		customer3.setDob(customer2.getDob());
		customer3.setEmail(customer3.getEmail());
		customer3.setName(customer2.getName());
		customer3.setUser1(customer2.getUser1());
		customer3.setUserId(customer2.getUserId());
		return customer3;
		
	}
	/*
	 public static Appointmentdto entityToDTO(Appointment appointment2) {
		Appointmentdto appointment3 = new Appointmentdto();
		appointment3.setAppointmentId(appointment2.getAppointmentId());
		appointment3.setLocation(appointment2.getLocation());
		appointment3.setVisitType(appointment2.getVisitType());
		appointment3.setPreferredDate(appointment2.getPreferredDate());
		appointment3.setPreferredTime(appointment2.getPreferredTime());
		return appointment3;
		
	} 
	 */
	 
	
	@Override
	public int hashCode() {
		return Objects.hash(contactNo, dob, email, name, user1, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customerdto other = (Customerdto) obj;
		return Objects.equals(contactNo, other.contactNo) && Objects.equals(dob, other.dob)
				&& Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(user1, other.user1) && Objects.equals(userId, other.userId);
	}
	
	
	
	
}
