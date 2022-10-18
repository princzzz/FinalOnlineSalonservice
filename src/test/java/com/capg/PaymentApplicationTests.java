package com.capg;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.capg.dto.Paymentdto;
import com.capg.entity.Payment;
import com.capg.exception.PaymentServiceNotFoundException;
import com.capg.repository.IPaymentRepository;
import com.capg.service.IPaymentService;
import com.capg.service.IPaymentServiceImp;

@SpringBootTest
public class PaymentApplicationTests {
	@Mock
	IPaymentRepository paymentRepository;
	
	@InjectMocks
	IPaymentService payment = new IPaymentServiceImp();
	
	public static Payment demo() {
		Payment pay = new Payment();
		pay.setPaymentId(1);
		pay.setType("Card");
		pay.setStatus("Ok");
		return pay;
	}

	@Test
	void validPaymentAddition() throws PaymentServiceNotFoundException{
		Paymentdto paymentDTO = Paymentdto.entityToDTO(PaymentApplicationTests.demo());
		Mockito.when(paymentRepository.findById(paymentDTO.getPaymentId())).thenReturn(Optional.empty());
		Assertions.assertEquals(payment.addPayment(Payment.DTOToentity(paymentDTO)), Payment.DTOToentity(paymentDTO));
	}

}