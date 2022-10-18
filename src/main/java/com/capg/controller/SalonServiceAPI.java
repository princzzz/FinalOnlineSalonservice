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

import com.capg.dto.Customerdto;
import com.capg.dto.SalonServicedto;
import com.capg.entity.SalonService;
import com.capg.exception.CustomerServiceNotFoundException;
import com.capg.exception.SalonServiceNotFoundException;
import com.capg.service.ISalonService;

@RestController
@RequestMapping(value = "/SalonService")
public class SalonServiceAPI {

	@Autowired
	private ISalonService salonService;
	
	@Autowired
	private Environment environment;  
	
	@GetMapping(value = "/service/{serviceId}")
	public ResponseEntity<SalonService> getService(@PathVariable Long serviceId) throws SalonServiceNotFoundException {
		SalonService s = salonService.getService(serviceId);
		return new ResponseEntity<>(s, HttpStatus.OK);
	} 
	
	@GetMapping(value = "/services")
	public ResponseEntity<List<SalonService>> getAllServices() throws SalonServiceNotFoundException {
		List<SalonService> s = salonService.getAllServices();
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	@PostMapping(value = "/service")
	public ResponseEntity<String> addService(@RequestBody SalonService s) throws SalonServiceNotFoundException {
		SalonService service = salonService.addService(s);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + service;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	
	@DeleteMapping(value = "/service/{serviceId}")
	public ResponseEntity<String> removeService(@PathVariable Long serviceId) throws SalonServiceNotFoundException {
		salonService.removeService(serviceId) ;
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	@PutMapping(value = "/service/{serviceId}")
	public ResponseEntity<String> updateService(@PathVariable Long serviceId, @RequestBody SalonService service)
			throws SalonServiceNotFoundException {
		salonService.updateService(serviceId, service);
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	@GetMapping(value = "/service/{serviceName}")
	public ResponseEntity<List<SalonService>> getServiceByName(@PathVariable String serviceName) throws SalonServiceNotFoundException {
		List<SalonService> s = salonService.getServiceByName(serviceName);
		return new ResponseEntity<>(s, HttpStatus.OK);
	} 
	@GetMapping(value = "/service/{servicePrice}")
	public ResponseEntity<List<SalonService>> getServiceByPrice(@PathVariable String servicePrice) throws SalonServiceNotFoundException {
		List<SalonService> s = salonService.getServiceByPrice(servicePrice);
		return new ResponseEntity<>(s, HttpStatus.OK);
	} 
	@GetMapping(value = "/service/{serviceDuration}")
	public ResponseEntity<List<SalonService>> getServiceByDuration(@PathVariable String serviceDuration) throws SalonServiceNotFoundException {
		List<SalonService> s = salonService.getServicesByDuration(serviceDuration);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
}