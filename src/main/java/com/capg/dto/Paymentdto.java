package com.capg.dto;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.capg.entity.Card;
import com.capg.entity.Payment;

public class Paymentdto {
	@NotNull(message = "Please provide valid paymentId")
	private long paymentId;
	private String type;
	private String status;
	private List<Card> cards;
	public static Paymentdto entityToDTO(Payment payment2) {
		Paymentdto pay3 = new Paymentdto();
		pay3.setPaymentId(payment2.getPaymentId());
		pay3.setType(payment2.getType());
		pay3.setStatus(payment2.getStatus());
		return pay3;
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(cards, paymentId, status, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paymentdto other = (Paymentdto) obj;
		return Objects.equals(cards, other.cards) && paymentId == other.paymentId
				&& Objects.equals(status, other.status) && Objects.equals(type, other.type);
	}
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