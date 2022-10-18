package com.capg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Payment {
	@Id
	private long paymentId;
	private String type;
	private String status;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="paymentId")
	private List<Card> cards;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(long paymentId, String type, String status, List<Card> cards) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.cards = cards;
	}
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", cards=" + cards + "]";
	}
	

}
