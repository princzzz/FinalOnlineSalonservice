package com.capg.service;

import java.util.List;

import com.capg.entity.Payment;
import com.capg.exception.PaymentServiceNotFoundException;

public interface IPaymentService {
	
	public Payment getPaymentDetails(long paymentId) throws PaymentServiceNotFoundException;
	public Payment addPayment(Payment payment) throws PaymentServiceNotFoundException;
	public Payment deletePayment(long paymentId) throws PaymentServiceNotFoundException;
	public Payment updatePayment(long paymentId, Payment payment) throws PaymentServiceNotFoundException;
	public List<Payment> getAllPaymentDetails() throws PaymentServiceNotFoundException;

}
