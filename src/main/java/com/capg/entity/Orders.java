package com.capg.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.capg.dto.Customerdto;
import com.capg.dto.Ordersdto;
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
	public static Orders DTOToentity(Ordersdto order3) {
		
		Orders order4 = new Orders();
		order4.setOrderId(order3.getOrderId());
		order4.setAmount(order3.getAmount());
		order4.setBillingDate(order3.getBillingDate());
		order4.setPaymentMethod(order3.getPaymentMethod());
		return order4;
	}
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
		Orders other = (Orders) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(billingDate, other.billingDate) && Objects.equals(customer, other.customer)
				&& orderId == other.orderId && Objects.equals(payment, other.payment)
				&& Objects.equals(paymentMethod, other.paymentMethod);
	}
	
	
	

}