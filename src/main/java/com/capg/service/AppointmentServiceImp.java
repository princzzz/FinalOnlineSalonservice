package com.capg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.dto.Appointmentdto;
import com.capg.entity.Appointment;
import com.capg.exception.AppointmentServiceNotFoundException;
import com.capg.repository.IAppointmentRepository;

@Service(value="appointmentService")
@Transactional
public class AppointmentServiceImp implements IAppointmentService{
	@Autowired
	private IAppointmentRepository appointmentRepository;
	
	@Override
	public Appointment addAppointment(Appointmentdto appointment) {
		Appointment appointmentEntity = new Appointment();
		appointmentEntity.setAppointmentId(appointment.getAppointmentId());
		appointmentEntity.setLocation(appointment.getLocation());
		appointmentEntity.setVisitType(appointment.getVisitType());
		appointmentEntity.setPreferredDate(appointment.getPreferredDate());
		appointmentEntity.setPreferredTime(appointment.getPreferredTime());
		
		//CustomerDTO
		/*
		Customer customer= new Customer();
		customer.setName(appointment.getCustomerdto().getName());
		customer.setEmail(appointment.getCustomerdto().getEmail());
		customer.setContactNo(appointment.getCustomerdto().getContactNo());
		appointment.setCustomer(customer);
		
		//PaymentDTO
		Payment payment= new Payment();
		payment.setPaymentId(appointment.getPayment().getPaymentId());
		payment.setStatus(appointment.getPayment().getStatus());
		payment.setType(appointment.getPayment().getType());
		appointment.setPayment(payment);
		
		//SalonService
		SalonService salonService= new SalonService();
		salonService.setServiceId(appointment.getSalonService().getServiceId());
		salonService.setServiceName(appointment.getSalonService().getServiceName());
		salonService.setServicePrice(appointment.getSalonService().getServicePrice());
		salonService.setServiceDuration(appointment.getSalonService().getServiceDuration());
		appointment.setSalonService(salonService);
		*/
		appointmentEntity.setPayment(appointment.getPayment());
		appointmentEntity.setSalonService(appointment.getSalonService());
		appointmentEntity.setCustomer(appointment.getCustomer());
		Appointment appointmentEntity2 = appointmentRepository.save(appointmentEntity);
		return appointmentEntity2;
	}
	
	@Override
	public void removeAppointment(long id)throws AppointmentServiceNotFoundException {
		Optional<Appointment> appointment = appointmentRepository.findById(id);
		appointment.orElseThrow(() -> new AppointmentServiceNotFoundException("Service.APPOINTMENT_NOT_FOUND"));
		appointmentRepository.deleteById(id);
	}
	
	@Override
	public void updateAppointment(long id,Appointment appointments)throws AppointmentServiceNotFoundException {
		Optional<Appointment> appointment = appointmentRepository.findById(id);
		Appointment a = appointment.orElseThrow(() -> new AppointmentServiceNotFoundException("Service.APPOINTMENT_NOT_FOUND"));
		a.setLocation(appointments.getLocation());
	}
	
	@Override
	public Appointmentdto getAppointment(Long id) throws AppointmentServiceNotFoundException{ 
		Optional<Appointment> optional = appointmentRepository.findById(id);
		Appointment appointment = optional.orElseThrow(() -> new AppointmentServiceNotFoundException("Service.APPOINTMENT_NOT_FOUND"));
		Appointmentdto appointment2 = new Appointmentdto();
		appointment2.setAppointmentId(appointment.getAppointmentId());
		appointment2.setSalonService(appointment.getSalonService());
		appointment2.setLocation(appointment.getLocation());
		appointment2.setPreferredDate(appointment.getPreferredDate());
		appointment2.setVisitType(appointment.getVisitType());
		
		appointment2.setPreferredTime(appointment.getPreferredTime());
		return appointment2;
	}
	
	@Override
	public List<Appointmentdto> getAllAppointments()throws AppointmentServiceNotFoundException {
		Iterable<Appointment> appointments = appointmentRepository.findAll(); 
		List<Appointmentdto> appointments2 = new ArrayList<>();
		appointments.forEach(appointment -> {
			Appointmentdto app = new Appointmentdto();
			app.setAppointmentId(appointment.getAppointmentId());
			app.setLocation(appointment.getLocation());
			app.setCustomer(appointment.getCustomer());
			app.setPreferredDate(appointment.getPreferredDate());
			app.setPreferredTime(appointment.getPreferredTime());
			appointments2.add(app);
		});
		if (appointments2.isEmpty())
			throw new AppointmentServiceNotFoundException("Service.APPOINTMENT_NOT_FOUND");
		return appointments2;
	}
	
	@Override
	public List<Appointmentdto> getOpenAppointments()throws AppointmentServiceNotFoundException {
		Iterable<Appointment> appointments = appointmentRepository.findAll(); 
		List<Appointmentdto> appointments2 = new ArrayList<>();
		appointments.forEach(appointment -> {
			Appointmentdto app = new Appointmentdto();
			if(appointment.getVisitType().equals("Open")) {
			app.setAppointmentId(appointment.getAppointmentId());
			app.setVisitType(appointment.getVisitType());
			app.setSalonService(appointment.getSalonService());
			app.setPreferredTime(appointment.getPreferredTime());
			app.setLocation(appointment.getLocation());
			app.setCustomer(appointment.getCustomer());
			app.setPreferredDate(appointment.getPreferredDate());
			app.setPreferredTime(appointment.getPreferredTime());
			appointments2.add(app);
			}
		});
		if (appointments2.isEmpty())
			throw new AppointmentServiceNotFoundException("Service.APPOINTMENT_NOT_FOUND");
		return appointments2;
	}
	
}
