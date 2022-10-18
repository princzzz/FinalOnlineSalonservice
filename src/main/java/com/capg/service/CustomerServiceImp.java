package com.capg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.dto.Addressdto;
import com.capg.dto.Customerdto;
import com.capg.entity.Address;
import com.capg.entity.Customer;
import com.capg.exception.CustomerServiceNotFoundException;
import com.capg.repository.ICustomerRepository;



@Service(value = "customerService")
@Transactional
public class CustomerServiceImp implements ICustomerService{
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public Customerdto getCustomer(Integer userId) throws CustomerServiceNotFoundException{ 
		Optional<Customer> optional = customerRepository.findById(userId);
		Customer customer = optional.orElseThrow(() -> new CustomerServiceNotFoundException("Service.CUSTOMER_NOT_FOUND"));
		Customerdto customer2 = new Customerdto();
		customer2.setUserId(customer.getUserId());
		customer2.setName(customer.getName());
		customer2.setEmail(customer.getEmail());
		customer2.setContactNo(customer.getContactNo());
		return customer2;
	}
	
	@Override
	public Integer addCustomer(Customerdto customer) throws CustomerServiceNotFoundException {
		Customer customerEntity = new Customer();
		customerEntity.setUserId(customer.getUserId());
		customerEntity.setName(customer.getName());
		customerEntity.setEmail(customer.getEmail());
		customerEntity.setContactNo(customer.getContactNo());
		customerEntity.setDob(customerEntity.getDob());
		
		 /*
	     Addressdto address= new Addressdto();
		 address.setArea(customer.getAddressdto().getArea());
		 address.setCity(customer.getAddressdto().getCity());
		 address.setDoor_no(customer.getAddressdto().getDoor_no());
		 address.setPincode(customer.getAddressdto().getPincode());
		 address.setState(customer.getAddressdto().getState());
		 address.setStreet(customer.getAddressdto().getStreet());
		 customer.setAddressdto(address); 
		 */
		 
		Customer customerEntity2 = customerRepository.save(customerEntity);
		return customerEntity2.getUserId();
	}
	
	@Override
	public Customer updateCustomer(Integer userId, Customerdto customer) throws CustomerServiceNotFoundException {
		Optional<Customer> customers = customerRepository.findById(userId);
		Customer c = customers.orElseThrow(() -> new CustomerServiceNotFoundException("Service.CUSTOMER_NOT_FOUND"));
		c.setContactNo(customer.getContactNo());
		return c;
		
		
	}

	@Override
	public void deleteCustomer(Integer userId) throws CustomerServiceNotFoundException {
		Optional<Customer> customer = customerRepository.findById(userId);
		customer.orElseThrow(() -> new CustomerServiceNotFoundException("Service.CUSTOMER_NOT_FOUND"));
		customerRepository.deleteById(userId);
	}

	@Override
	public List<Customerdto> getAllCustomers() throws CustomerServiceNotFoundException {
		Iterable<Customer> customers = customerRepository.findAll(); 
		List<Customerdto> customers2 = new ArrayList<>();
		customers.forEach(customer -> {
			Customerdto cust = new Customerdto();
			cust.setUserId(customer.getUserId());
			cust.setName(customer.getName());
			cust.setContactNo(customer.getContactNo());
			customers2.add(cust);
		});
		if (customers2.isEmpty())
			throw new CustomerServiceNotFoundException("Service.CUSTOMERS_NOT_FOUND");
		return customers2;
	}
}
