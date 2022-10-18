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
import com.capg.dto.Appointmentdto;
import com.capg.entity.Appointment;
import com.capg.exception.AppointmentServiceNotFoundException;
import com.capg.exception.CustomerServiceNotFoundException;
import com.capg.service.IAppointmentService;

@RestController
@RequestMapping(value="/appointment")
public class AppointmentAPI {
@Autowired
private IAppointmentService iappointmentService;
@Autowired
private Environment environment;
@GetMapping(value = "/{id}")
public ResponseEntity<Appointmentdto> getAppointment(@PathVariable Long id) throws AppointmentServiceNotFoundException{
	Appointmentdto appointment = iappointmentService.getAppointment(id);
	return new ResponseEntity<>(appointment, HttpStatus.OK);
}

@GetMapping(value = "/getAll")
public ResponseEntity<List<Appointmentdto>> getAllAppointments() throws AppointmentServiceNotFoundException {
	List<Appointmentdto> appointmentList = iappointmentService.getAllAppointments();
	return new ResponseEntity<>(appointmentList, HttpStatus.OK);
}

@GetMapping(value = "/getOpenAppointments")
public ResponseEntity<List<Appointmentdto>> getOpenAppointments()throws AppointmentServiceNotFoundException {
	List<Appointmentdto> appointmentList = iappointmentService.getOpenAppointments();
	return new ResponseEntity<>(appointmentList, HttpStatus.OK);
}

@PostMapping(value = "/addAppointment")
public ResponseEntity<String> addCustomer(@RequestBody Appointmentdto appoitntmet) throws CustomerServiceNotFoundException {
	Appointment app = iappointmentService.addAppointment(appoitntmet);
	String successMessage = environment.getProperty("API.INSERT_SUCCESS") + app;
	return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
}

@PutMapping(value = "/updateAppointment/{id}")
public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody Appointment appointment)
		throws AppointmentServiceNotFoundException {
	iappointmentService.updateAppointment(id, appointment);
	String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
	return new ResponseEntity<>(successMessage, HttpStatus.OK);
}

@DeleteMapping(value = "/deleteAppointment/{id}")
public ResponseEntity<String> removeAppointment(@PathVariable Long id)throws AppointmentServiceNotFoundException {
	iappointmentService.removeAppointment(id);
	String successMessage = environment.getProperty("API.DELETE_SUCCESS");
	return new ResponseEntity<>(successMessage, HttpStatus.OK);
} 

}
