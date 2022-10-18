package com.capg.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.capg.entity.Customer;
import com.capg.entity.Orders;
import com.capg.entity.Payment;

public class Ordersdto {

	@NotNull(message = "Please provide valid orderId")
	private long orderId;
	private double amount;
	private LocalDate billingDate;
	private Payment payment;
	private String paymentMethod;
	private Customer customer;
	public static Ordersdto entityToDTO(Orders order1) {
		Ordersdto order2 = new Ordersdto();
		order2.setOrderId(order1.getOrderId());
		order2.setAmount(order1.getAmount());
		order2.setBillingDate(order1.getBillingDate());
		order2.setPaymentMethod(order1.getPaymentMethod());
		return order2;
		
	}
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
	@Override
	public int hashCode() {
		return Objects.hash(amount, billingDate, customer, orderId, payment, paymentMethod);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordersdto other = (Ordersdto) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(billingDate, other.billingDate) && Objects.equals(customer, other.customer)
				&& orderId == other.orderId && Objects.equals(payment, other.payment)
				&& Objects.equals(paymentMethod, other.paymentMethod);
	}
	
	
	
}