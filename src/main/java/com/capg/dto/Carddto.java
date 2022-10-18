package com.capg.dto;

import java.time.LocalDate;

public class Carddto {

	private long id;
	private String cardName;
	private String cardNumber;
	private String bankName ;
	private LocalDate expiryDate;
	public long getId() {
		return id;
	}
	public String getCardName() {
		return cardName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "Carddto [id=" + id + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", bankName=" + bankName
				+ ", expiryDate=" + expiryDate + "]";
	}
	
	
}
