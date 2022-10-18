package com.capg;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.dto.Ordersdto;
import com.capg.dto.Paymentdto;
import com.capg.entity.Orders;
import com.capg.entity.Payment;
import com.capg.exception.OrderServiceNotFoundException;
import com.capg.exception.PaymentServiceNotFoundException;
import com.capg.repository.IOrderRepository;
import com.capg.repository.IPaymentRepository;
import com.capg.service.IOrderService;
import com.capg.service.IPaymentService;
import com.capg.service.IPaymentServiceImp;
import com.capg.service.OrderServiceImp;

@SpringBootTest
public class OrdersApplicationTests {
	@Mock
	IOrderRepository orderRepository;
	
	@InjectMocks
	IOrderService orders = new OrderServiceImp();
	
	public static Orders demo() {
		Orders ord = new Orders();
		ord.setOrderId(1);
		ord.setBillingDate(LocalDate.of(2000, 01, 01));
		ord.setAmount(100.20);
		ord.setPaymentMethod("Upi");
		return ord;
	}
	@Test
	void validOrdersAddition() throws OrderServiceNotFoundException{
		Ordersdto orderDTO = Ordersdto.entityToDTO(OrdersApplicationTests.demo());
		Mockito.when(orderRepository.findById(orderDTO.getOrderId())).thenReturn(Optional.empty());
		Assertions.assertEquals(orders.addOrder(Orders.DTOToentity(orderDTO)), Orders.DTOToentity(orderDTO));
	}


	

}