package com.arnab.ecom_order.service;

import java.util.List;

import com.arnab.ecom_order.dto.OrderDto;
import com.arnab.ecom_order.dto.OrderFinalResponseDto;
import com.arnab.ecom_order.dto.PaymentResponseDto;
import com.arnab.ecom_order.dto.PaymentRequestDto;

public interface OrderService {

	public OrderFinalResponseDto save(OrderDto orderDto);
	
	public List<OrderDto> getAll();
	
	public OrderDto get(String orderId);
	
	public PaymentResponseDto paymentDetails(PaymentRequestDto paymentServiceDto); 
}
