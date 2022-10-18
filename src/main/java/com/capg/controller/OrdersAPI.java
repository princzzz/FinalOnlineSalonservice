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
import com.capg.entity.Orders;
import com.capg.exception.OrderServiceNotFoundException;
import com.capg.service.IOrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrdersAPI {

	
	@Autowired
	private IOrderService iOrderService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/{orderId}")
	public ResponseEntity<Orders> getOrderDetails(@PathVariable Long orderId) throws OrderServiceNotFoundException {
		Orders orders=iOrderService.getOrderDetails(orderId);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	@GetMapping(value = "/getAllOrder")
	public ResponseEntity<List<Orders>> getAllOrders() throws OrderServiceNotFoundException {
		List<Orders> orderList = iOrderService.getAllOrders();
		return new ResponseEntity<>(orderList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/addOrder")
	public ResponseEntity<String> addOrder(@RequestBody Orders order) throws OrderServiceNotFoundException {
		Orders orderId = iOrderService.addOrder(order);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + orderId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/updateOrder/{orderId}")
	public ResponseEntity<String> updateOrder(@PathVariable Long OrderId, @RequestBody Orders order) throws OrderServiceNotFoundException {
		iOrderService.updateOrder(OrderId, order) ;
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK); 
	}
	
	
	@DeleteMapping(value = "/deleteOrder/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long OrderId) throws OrderServiceNotFoundException {
		iOrderService.deleteOrder(OrderId) ;
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	
}


