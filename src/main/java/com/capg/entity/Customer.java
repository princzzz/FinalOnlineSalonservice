package com.capg.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.capg.dto.Appointmentdto;
import com.capg.dto.Customerdto;
@Entity
public class Customer {
    @Id
	private Integer userId;
	private String name;
	private String email;
	private String contactNo;
	private LocalDate dob;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user1Id")
	private User1 user1;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private Set<Address> houseno;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer userId, String name, String email, String contactNo, LocalDate dob, User1 user1,
			Set<Address> houseno) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.user1 = user1;
		this.houseno = houseno;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public User1 getUser1() {
		return user1;
	}
	public void setUser1(User1 user1) {
		this.user1 = user1;
	}
	public Set<Address> getHouseno() {
		return houseno;
	}
	public void setHouseno(Set<Address> houseno) {
		this.houseno = houseno;
	}
	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", user1=" + user1 + ", houseno=" + houseno + "]";
	}
	
	public static Customer DTOToentity(Customerdto customer2) {
		Customer customer3 = new Customer();
		customer3.setContactNo(customer2.getContactNo());
		customer3.setDob(customer2.getDob());
		customer3.setEmail(customer3.getEmail());
		customer3.setName(customer2.getName());
		customer3.setUser1(customer2.getUser1());
		customer3.setUserId(customer2.getUserId());
		return customer3;
		
	}
	
	/*
	 public static Appointment DTOtoentity(Appointmentdto appointment2) {
		Appointment appointment3 = new Appointment();
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
		return Objects.hash(contactNo, dob, email, houseno, name, user1, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(contactNo, other.contactNo) && Objects.equals(dob, other.dob)
				&& Objects.equals(email, other.email) && Objects.equals(houseno, other.houseno)
				&& Objects.equals(name, other.name) && Objects.equals(user1, other.user1)
				&& Objects.equals(userId, other.userId);
	}
}
