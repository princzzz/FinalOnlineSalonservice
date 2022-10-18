package com.capg.controller;

import java.util.List;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.Customerdto;
import com.capg.entity.Customer;
import com.capg.exception.CustomerServiceNotFoundException;
import com.capg.exception.SalonServiceNotFoundException;
import com.capg.service.ICustomerService;


@RestController
@RequestMapping(value = "/Customer")
@CrossOrigin("*")
public class CustomerAPI {

	@Autowired
	private ICustomerService icustomerService;
	
	@Autowired
	private Environment environment;
	
	public static final Log LOGGER=LogFactory.getLog(CustomerAPI.class);

	@GetMapping(value = "/customers/{userId}")
	public ResponseEntity<Customerdto> getCustomer(@PathVariable Integer userId) throws CustomerServiceNotFoundException {
		Customerdto customer = icustomerService.getCustomer(userId);
		LOGGER.info(environment.getProperty("CustomerAPI.INSERT_SUCCESS"));
		return new ResponseEntity<>(customer, HttpStatus.OK); 
	}
	
	@GetMapping(value = "/customers") 
	public ResponseEntity<List<Customerdto>> getAllCustomers() throws CustomerServiceNotFoundException {
		List<Customerdto> customerList = icustomerService.getAllCustomers();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/customers")
	public ResponseEntity<String> addCustomer(@RequestBody Customerdto customer) throws CustomerServiceNotFoundException {
		Integer userId = icustomerService.addCustomer(customer);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + userId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/customers/{userId}")
	public ResponseEntity<String> updateCustomer(@PathVariable Integer userId, @RequestBody Customerdto customer)
			throws CustomerServiceNotFoundException {
		icustomerService.updateCustomer(userId, customer);
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	

	@DeleteMapping(value = "/customers/{userId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer userId) throws CustomerServiceNotFoundException {
		icustomerService.deleteCustomer(userId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	} 
}
