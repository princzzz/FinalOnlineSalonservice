package com.capg.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {
	@Id
	private long id;
	private String cardName;
	private String cardNumber;
	private String bankName ;
	private LocalDate expiryDate;
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(long id, String cardName, String cardNumber, String bankName, LocalDate expiryDate) {
		super();
		this.id = id;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.bankName = bankName;
		this.expiryDate = expiryDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "Card [id=" + id + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", bankName=" + bankName
				+ ", expiryDate=" + expiryDate + "]";
	}
   
}
