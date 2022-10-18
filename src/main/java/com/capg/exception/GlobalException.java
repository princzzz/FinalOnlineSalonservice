package com.capg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalException  {
	
	@ExceptionHandler(value= AppointmentServiceNotFoundException.class)
	public ResponseEntity<String>AppointmentServiceNotFoundException(AppointmentServiceNotFoundException appointmentServiceNotFoundException){
		return new ResponseEntity<String>("Appointment not found, Try with another Appointment Id", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=CustomerServiceNotFoundException.class)
	public ResponseEntity<String> CustomerServiceNotFoundException(CustomerServiceNotFoundException customerServiceNotFoundException)
	{
		return new ResponseEntity<String>("No service found.",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = OrderServiceNotFoundException.class)
	public ResponseEntity<String> OrderServiceNotFoundException(OrderServiceNotFoundException orderServiceNotFoundException){
		return new ResponseEntity<String>("Order not found. Please try again",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value= PaymentServiceNotFoundException.class)
	public ResponseEntity<String> PaymentServiceNotFoundException(PaymentServiceNotFoundException paymentServiceNotFoundException){
		return new ResponseEntity<String>("Payment Not found", HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(value=SalonServiceNotFoundException.class)
	public ResponseEntity<String> SalonServiceNotFoundException(SalonServiceNotFoundException salonServiceNotFoundException)
	{
		return new ResponseEntity<String>("Salon service not found.",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=UserServiceNotFoundException.class)
	public ResponseEntity<String> UserServiceNotFoundException(UserServiceNotFoundException userServiceNotFoundException)
	{
		return new ResponseEntity<String>("User service not found.",HttpStatus.NOT_FOUND);
	}
	


}