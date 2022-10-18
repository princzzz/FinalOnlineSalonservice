package com.capg.dto;

import java.util.List;

import com.capg.entity.Card;

public class Paymentdto {

	private long paymentId;
	private String type;
	private String status;
	private List<Card> cards;
	public long getPaymentId() {
		return paymentId;
	}
	public String getType() {
		return type;
	}
	public String getStatus() {
		return status;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	@Override
	public String toString() {
		return "Paymentdto [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", cards=" + cards
				+ "]";
	}
	
	
}
