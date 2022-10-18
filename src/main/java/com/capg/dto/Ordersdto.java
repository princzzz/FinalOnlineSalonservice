package com.capg.dto;

import java.time.LocalDate;

import com.capg.entity.Customer;
import com.capg.entity.Payment;

public class Ordersdto {

	private long orderId;
	private double amount;
	private LocalDate billingDate;
	private Payment payment;
	private String paymentMethod;
	private Customer customer;
	public long getOrderId() {
		return orderId;
	}
	public double getAmount() {
		return amount;
	}
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public Payment getPayment() {
		return payment;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Ordersdto [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + ", payment="
				+ payment + ", paymentMethod=" + paymentMethod + ", customer=" + customer + "]";
	}
	
	
}
