package com.capg.service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.entity.Customer;
import com.capg.entity.Orders;
import com.capg.entity.Payment;
import com.capg.exception.OrderServiceNotFoundException;
import com.capg.repository.IOrderRepository;

@Service(value = "orderService")
@Transactional

public class OrderServiceImp implements IOrderService{
	
	@Autowired
	private IOrderRepository orderRepository;
	
	@Override
	public Orders addOrder(Orders order) throws OrderServiceNotFoundException{
		Orders orderEntity = new Orders();
		orderEntity.setOrderId(order.getOrderId());
		orderEntity.setAmount(order.getAmount());
		orderEntity.setBillingDate(order.getBillingDate());
		orderEntity.setPaymentMethod(order.getPaymentMethod());
		orderEntity.setCustomer(order.getCustomer());
		orderEntity.setPayment(order.getPayment());	
		/*Customer custm = new Customer();
		custm.setUserId(order.getCustomer().getUserId());
		orderEntity.setCustomer(custm);
		
		Payment paym = new Payment();
		paym.setPaymentId(order.getPayment().getPaymentId());
		orderEntity.setPayment(paym);*/
			
		Orders orderEntity2 = orderRepository.save(orderEntity);
		return orderEntity2;
		
	}
	@Override
	public Orders deleteOrder(Long orderId) throws OrderServiceNotFoundException{
		
		Optional<Orders> orders = orderRepository.findById(orderId);
		Orders ord = orders.orElseThrow(() -> new OrderServiceNotFoundException("Service.Order_NOT_FOUND"));
		orderRepository.deleteById(orderId);
		return ord;
		
		
	}
	@Override
	public Orders updateOrder(Long orderId, Orders order) throws OrderServiceNotFoundException{
		Optional<Orders> order1 = orderRepository.findById(orderId);
		Orders o = order1.orElseThrow(() -> new OrderServiceNotFoundException("Service.Order_NOT_FOUND"));
		o.setPaymentMethod(order.getPaymentMethod());
		o.setAmount(order.getAmount());
		o.setBillingDate(order.getBillingDate());
		return o;
		
	}
	@Override
	public Orders getOrderDetails(Long orderId) throws OrderServiceNotFoundException{
		Optional<Orders> optional = orderRepository.findById(orderId);
		Orders ord = optional.orElseThrow(() -> new OrderServiceNotFoundException("Service.Order_NOT_FOUND"));
		Orders order1 = new Orders();
		order1.setAmount(ord.getAmount());
		order1.setBillingDate(ord.getBillingDate());
		order1.setPaymentMethod(ord.getPaymentMethod());
		order1.setCustomer(ord.getCustomer());
		order1.setPayment(ord.getPayment());
		return order1;
	}
	public List<Orders> getAllOrders() throws OrderServiceNotFoundException{
		Iterable<Orders> order2 = orderRepository.findAll(); 
		List<Orders> order3 = new ArrayList<>();
		order2.forEach(order -> {
			Orders ords = new Orders();
			ords.setOrderId(order.getOrderId());
			ords.setAmount(order.getAmount());
			ords.setBillingDate(order.getBillingDate());
			ords.setPaymentMethod(order.getPaymentMethod());
			ords.setCustomer(order.getCustomer());
			ords.setPayment(order.getPayment());
			order3.add(ords);
		});
		if (order3.isEmpty())
			throw new OrderServiceNotFoundException("Service.Order_NOT_FOUND");
		return order3;
	}

}