package com.capg.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Payment;
import com.capg.exception.PaymentServiceNotFoundException;
import com.capg.service.IPaymentService;


@RestController
@RequestMapping(value= "/payment")

public class PaymentAPI {
	@Autowired
	private IPaymentService  iPaymentService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/getPayment/{paymentId}")
	public ResponseEntity<Payment> getPaymentDetails(@PathVariable Long paymentId) throws PaymentServiceNotFoundException{
		Payment payment = iPaymentService.getPaymentDetails(paymentId); 
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllPayment")
	public ResponseEntity<List<Payment>> getAllPaymentDetails() throws PaymentServiceNotFoundException {
		List<Payment> paymentDetailsList = iPaymentService.getAllPaymentDetails();
		return new ResponseEntity<>(paymentDetailsList, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/{paymentId}")
	public ResponseEntity<String> updatePayment(@PathVariable Long paymentId, @RequestBody Payment payment)
			throws PaymentServiceNotFoundException {
		iPaymentService.updatePayment(paymentId, payment);
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage,HttpStatus.OK);
		
	}
	@DeleteMapping(value = "/delete/{paymentId}")
	public ResponseEntity<String> deletePayment(@PathVariable Long paymentId)
			throws PaymentServiceNotFoundException {
		iPaymentService.deletePayment(paymentId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage ,HttpStatus.OK);
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> addPayment(@RequestBody Payment payment) throws PaymentServiceNotFoundException {
		Payment paymentId = iPaymentService.addPayment(payment);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + paymentId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

}
