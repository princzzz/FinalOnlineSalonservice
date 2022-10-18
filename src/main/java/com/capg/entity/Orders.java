package com.capg.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Orders {
	@Id
	private long orderId;
	private double amount;
	private LocalDate billingDate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentId")
	private Payment payment;
	private String paymentMethod;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "userId")
	private Customer customer;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(long orderId, double amount, LocalDate billingDate, Payment payment, String paymentMethod,
			Customer customer) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.payment = payment;
		this.paymentMethod = paymentMethod;
		this.customer = customer;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + ", payment="
				+ payment + ", paymentMethod=" + paymentMethod + ", customer=" + customer + "]";
	}
	
	

}
