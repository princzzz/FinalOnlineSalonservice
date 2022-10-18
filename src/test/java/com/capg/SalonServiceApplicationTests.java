package com.capg;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.dto.SalonServicedto;
import com.capg.entity.SalonService;
import com.capg.exception.SalonServiceNotFoundException;
import com.capg.repository.ISalonRepository;
import com.capg.service.ISalonService;
import com.capg.service.SalonServiceImp;

@SpringBootTest
class SalonServiceApplicationTests {
	@Mock
	ISalonRepository salonRepository;
	
	@InjectMocks
	ISalonService salon = new SalonServiceImp();
	
	public static SalonService demo() {
		SalonService s = new SalonService();
		s.setServiceId(1);
		s.setServiceName("Haircut");
		s.setServicePrice("200");
		s.setServiceDuration("60");
		s.setDiscount(10);
		return s;
	}

	@Test
	void validSalonServiceAddition() throws SalonServiceNotFoundException{
		SalonServicedto salonDTO = SalonServicedto.entityToDTO(SalonServiceApplicationTests.demo());
		Mockito.when(salonRepository.findById(salonDTO.getServiceId())).thenReturn(Optional.empty());
		Assertions.assertEquals(salon.addService(SalonService.DTOToentity(salonDTO)), SalonService.DTOToentity(salonDTO));
	}
	/*
	@Test
	void invalidTraineeAddition() throws WomenEmpException{
		Trainee trainee = WomenEmpowermentApplicationTests.demo();
		Mockito.when(traineeRepository.findById(trainee.getTraineeId())).thenReturn(Optional.of(trainee));
		WomenEmpException ex = Assertions.assertThrows(WomenEmpException.class, () -> traineeService.addTrainee(TraineeDTO.entityToDTO(trainee)));
		Assertions.assertEquals(ex.getMessage(), "Service.TRAINEE_ALREADY_PRESENT");
	}
	
	@Test
	void validTraineeUpdate() throws WomenEmpException{
		Trainee trainee = WomenEmpowermentApplicationTests.demo();
		Mockito.when(traineeRepository.findById(trainee.getTraineeId())).thenReturn(Optional.of(trainee));
		Assertions.assertEquals(traineeService.updateTrainee(TraineeDTO.entityToDTO(trainee)), TraineeDTO.entityToDTO(trainee));
	}
	
	@Test
	void invalidTraineeUpdate() throws WomenEmpException{
		TraineeDTO traineeDTO = TraineeDTO.entityToDTO(WomenEmpowermentApplicationTests.demo());
		Mockito.when(traineeRepository.findById(traineeDTO.getTraineeId())).thenReturn(Optional.empty());
		WomenEmpException ex = Assertions.assertThrows(WomenEmpException.class, () -> traineeService.updateTrainee(traineeDTO));
		Assertions.assertEquals(ex.getMessage(), "Service.TRAINEE_NOT_PRESENT");
	}
	
	@Test
	void validViewTrainee() throws WomenEmpException{
		Trainee trainee = WomenEmpowermentApplicationTests.demo();
		Mockito.when(traineeRepository.findById(trainee.getTraineeId())).thenReturn(Optional.of(trainee));
		Assertions.assertEquals(traineeService.viewTrainee(trainee.getTraineeId()), TraineeDTO.entityToDTO(trainee));
	}
	
	@Test
	void invalidViewTrainee() throws WomenEmpException{
		TraineeDTO traineeDTO = TraineeDTO.entityToDTO(WomenEmpowermentApplicationTests.demo());
		Mockito.when(traineeRepository.findById(traineeDTO.getTraineeId())).thenReturn(Optional.empty());
		WomenEmpException ex = Assertions.assertThrows(WomenEmpException.class, ()-> traineeService.viewTrainee(traineeDTO.getTraineeId()));
		Assertions.assertEquals(ex.getMessage(), "Service.TRAINEE_NOT_PRESENT");
	}

	@Test
	void validViewAllTrainee() throws WomenEmpException{
		Trainee trainee = WomenEmpowermentApplicationTests.demo();
		List<Trainee> list = new ArrayList<>();
		list.add(trainee);
		Mockito.when(traineeRepository.findAll()).thenReturn(list);
		List<TraineeDTO> listDTO = new ArrayList<>();
		list.forEach(p -> {
			listDTO.add(TraineeDTO.entityToDTO(p));
		});
		Assertions.assertEquals(traineeService.viewAllTrainee(), listDTO);
	}
	
	@Test
	void invalidViewAllTrainee() throws WomenEmpException{
		Mockito.when(traineeRepository.findAll()).thenReturn(new ArrayList<Trainee>());
		WomenEmpException ex = Assertions.assertThrows(WomenEmpException.class, ()-> traineeService.viewAllTrainee());
		Assertions.assertEquals(ex.getMessage(), "Service.TRAINEE_NOT_PRESENT");
	}
	
	@Test
	void validDeleteTrainee() throws WomenEmpException{
		Trainee trainee = WomenEmpowermentApplicationTests.demo();
		Mockito.when(traineeRepository.findById(trainee.getTraineeId())).thenReturn(Optional.of(trainee));
		Assertions.assertDoesNotThrow(() -> traineeService.deleteTrainee(trainee.getTraineeId()));
	}
	
	@Test
	void invalidDeleteTrainee() throws WomenEmpException{
		TraineeDTO traineeDTO = TraineeDTO.entityToDTO(WomenEmpowermentApplicationTests.demo());
		Mockito.when(traineeRepository.findById(traineeDTO.getTraineeId())).thenReturn(Optional.empty());
		WomenEmpException ex = Assertions.assertThrows(WomenEmpException.class, ()-> traineeService.deleteTrainee(traineeDTO.getTraineeId()));
		Assertions.assertEquals(ex.getMessage(), "Service.TRAINEE_NOT_PRESENT");
	}
	
	@Test
	void validViewAllTraineesByLocation() throws WomenEmpException{
		Trainee trainee = WomenEmpowermentApplicationTests.demo();
		List<Trainee> list = new ArrayList<>();
		list.add(trainee);
		Mockito.when(traineeRepository.findByLocation(trainee.getLocation())).thenReturn(list);
		List<TraineeDTO> listDTO = new ArrayList<>();
		list.forEach(p->{
			listDTO.add(TraineeDTO.entityToDTO(p));
		});
		Assertions.assertEquals(traineeService.viewAllTraineeByLocation(trainee.getLocation()), listDTO);
	}
	
	@Test
	void invalidViewAllTraineesByLocation() throws WomenEmpException{
		TraineeDTO traineeDTO = TraineeDTO.entityToDTO(WomenEmpowermentApplicationTests.demo());
		Mockito.when(traineeRepository.findByLocation(traineeDTO.getLocation())).thenReturn(new ArrayList<>());
		WomenEmpException ex = Assertions.assertThrows(WomenEmpException.class, ()-> traineeService.viewAllTraineeByLocation(traineeDTO.getLocation()));
		Assertions.assertEquals(ex.getMessage(), "Service.TRAINEE_NOT_PRESENT");
	}
	
	@Test
	void validViewTraineeByAadhar() throws WomenEmpException{
		Trainee trainee = WomenEmpowermentApplicationTests.demo();
		Mockito.when(traineeRepository.findByAadharNo(trainee.getAadharNo())).thenReturn(trainee);
		Assertions.assertEquals(traineeService.viewTraineeByAadhar(trainee.getAadharNo()), TraineeDTO.entityToDTO(trainee));
	}
	
	@Test
	void invalidViewTraineeByAadhar() throws WomenEmpException{
		TraineeDTO traineeDTO = TraineeDTO.entityToDTO(WomenEmpowermentApplicationTests.demo());
		Mockito.when(traineeRepository.findByAadharNo(traineeDTO.getAadharNo())).thenReturn(null);
		WomenEmpException ex = Assertions.assertThrows(WomenEmpException.class, ()-> traineeService.viewTraineeByAadhar(traineeDTO.getAadharNo()));
		Assertions.assertEquals(ex.getMessage(), "Service.INVALID_AADHAR");
	}
}

@SpringBootTest
class SalonServiceApplicationTests {

	@Test
	void contextLoads() {
	}
*/
}