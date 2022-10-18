package com.capg.service;

import java.util.List;
import com.capg.entity.Orders;
import com.capg.exception.OrderServiceNotFoundException;


public interface IOrderService {
	
	public Orders addOrder(Orders order) throws OrderServiceNotFoundException;
	public Orders deleteOrder(Long orderId) throws OrderServiceNotFoundException;
	public Orders updateOrder(Long orderId, Orders order) throws OrderServiceNotFoundException;
	public Orders getOrderDetails(Long orderId) throws OrderServiceNotFoundException;
	public List<Orders> getAllOrders() throws OrderServiceNotFoundException ;
}