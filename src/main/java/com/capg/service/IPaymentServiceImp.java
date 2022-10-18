package com.capg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Payment;
import com.capg.exception.PaymentServiceNotFoundException;
import com.capg.repository.IPaymentRepository;


@Service(value = "paymentService")
@Transactional

public class IPaymentServiceImp implements IPaymentService {
	
	@Autowired
	private IPaymentRepository iPaymentRepository;
	
	//Get Payment Info
		@Override
	   public Payment getPaymentDetails(long paymentId) throws PaymentServiceNotFoundException{ 
			Optional<Payment> optional = iPaymentRepository.findById(paymentId);
			Payment payment  = optional.orElseThrow(() -> new PaymentServiceNotFoundException("Service.CUSTOMER_NOT_FOUND"));
			Payment payment2 = new Payment();
			payment2.setPaymentId(payment.getPaymentId());
			payment2.setType(payment.getType());
			payment2.setStatus(payment.getStatus());
			return payment2;
		}
	
		//Add Payment Details
		@Override
		public Payment addPayment(Payment payment) throws PaymentServiceNotFoundException{
			
			Payment paymentInfo = new Payment();
			paymentInfo.setPaymentId(payment.getPaymentId());
			paymentInfo.setStatus(payment.getStatus());
			paymentInfo.setType(payment.getType());
			paymentInfo.setCards(payment.getCards());
			
			/*CardDTO card = new CardDTO();
			card.setId(payment.getCardDTO().getId());
			card.setBankName(payment.getCardDTO().getBankName());
			card.setCardName(payment.getCardDTO().getCardName());
			card.setCardNumber(payment.getCardDTO().getCardNumber());
			card.setExpiryDate(payment.getCardDTO().getExpiryDate());
			paymentInfo.set*/
			Payment paymentInformation = iPaymentRepository.save(paymentInfo);
			return paymentInformation;
			
			
		}
		
		//Update Payment Information
		@Override
		public Payment updatePayment(long paymentId, Payment payment) throws PaymentServiceNotFoundException{
			Optional<Payment> payment1 = iPaymentRepository.findById(paymentId);
			Payment p = payment1.orElseThrow(() -> new PaymentServiceNotFoundException("Service.CUSTOMER_NOT_FOUND"));
			p.setStatus(payment.getStatus());
			return p;
		}
		
		//Delete Payment Information
		@Override
		public Payment deletePayment(long paymentId) throws PaymentServiceNotFoundException{
			Optional<Payment> payment1 = iPaymentRepository.findById(paymentId);
			Payment p = payment1.orElseThrow(() -> new PaymentServiceNotFoundException("Service.CUSTOMER_NOT_FOUND"));
			iPaymentRepository.deleteById(paymentId);
			return p;
		}
		
		//GetAll payment Details
		public List<Payment> getAllPaymentDetails() throws PaymentServiceNotFoundException{
			Iterable<Payment> payments = iPaymentRepository.findAll(); 
			List<Payment> payments2 = new ArrayList<>();
			payments.forEach(payment -> {
				Payment paym = new Payment();
				paym.setPaymentId(payment.getPaymentId());
				paym.setType(payment.getType());
				paym.setStatus(payment.getStatus());
				payments2.add(paym);
			});
			if (payments2.isEmpty())
				throw new PaymentServiceNotFoundException("Service.CUSTOMERS_NOT_FOUND");
			return payments2;
		}
		

}