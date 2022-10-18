package com.capg.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.capg.dto.Paymentdto;
import com.capg.dto.SalonServicedto;
@Entity
public class Payment {
	@Id
	private long paymentId;
	private String type;
	private String status;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="paymentId")
	private List<Card> cards;
	public static Payment DTOToentity(Paymentdto paymentDTO) {
		Payment pay2 = new Payment();
		pay2.setPaymentId(paymentDTO.getPaymentId());
		pay2.setType(paymentDTO.getType());
		pay2.setStatus(paymentDTO.getStatus());
		return pay2;
		
	}
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
		Payment other = (Payment) obj;
		return Objects.equals(cards, other.cards) && paymentId == other.paymentId
				&& Objects.equals(status, other.status) && Objects.equals(type, other.type);
	}
	
	

}