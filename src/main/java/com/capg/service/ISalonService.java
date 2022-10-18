package com.capg.service;

import java.util.List;

import com.capg.dto.SalonServicedto;
import com.capg.entity.SalonService;
import com.capg.exception.SalonServiceNotFoundException;

public interface ISalonService {

	public SalonService addService(SalonService salonService) throws SalonServiceNotFoundException;
	public SalonService removeService(Long serviceId) throws SalonServiceNotFoundException;
     public void updateService(Long serviceId, SalonService salonService) throws SalonServiceNotFoundException;
	public SalonService getService(Long serviceId) throws SalonServiceNotFoundException;
	public List<SalonService> getAllServices() throws SalonServiceNotFoundException;
	public List<SalonService> getServiceByName(String serviceName) throws SalonServiceNotFoundException;
	public List<SalonService> getServiceByPrice(String servicePrice) throws SalonServiceNotFoundException;
	public List<SalonService> getServicesByDuration(String serviceDuration) throws SalonServiceNotFoundException;
}
