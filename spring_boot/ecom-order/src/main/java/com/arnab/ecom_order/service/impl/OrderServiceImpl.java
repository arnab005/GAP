package com.arnab.ecom_order.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.ecom_order.dto.OrderDto;
import com.arnab.ecom_order.dto.OrderFinalResponseDto;
import com.arnab.ecom_order.dto.PaymentRequestDto;
import com.arnab.ecom_order.dto.PaymentResponseDto;
import com.arnab.ecom_order.entity.Order;
import com.arnab.ecom_order.repository.OrderRepository;
import com.arnab.ecom_order.service.OrderService;
import com.arnab.ecom_order.service.PaymentService;
import com.arnab.ecom_order.utils.GenericMapper;
import com.arnab.ecom_order.utils.OrderMapStructMapper;
import com.arnab.ecom_order.utils.OrderUtilsMapper;

@Service
public class OrderServiceImpl implements OrderService {

	// private OrderUtilsMapper orderUtilsMapper = OrderUtilsMapper.INSTANCE;

//	@Autowired
//	private OrderMapStructMapper orderMapStructMapper;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private GenericMapper<OrderDto, Order> mapper;

	@Autowired
	private OrderRepository orderRepository;

//	@Override
//	public OrderDto save(OrderDto orderDto) {
//		return orderMapStructMapper.toDto(orderRepository.save(orderMapStructMapper.toEntity(orderDto)));
//	}

	@Override
	public OrderFinalResponseDto save(OrderDto orderDto) {
		OrderFinalResponseDto orderFinalResponseDto = new OrderFinalResponseDto();
		OrderDto orderDtoResponseDto = mapper.toDTO(orderRepository.save(mapper.toEntity(orderDto))); 
		PaymentResponseDto paymentResponseDto = paymentService.orderPayment(orderDto.getPaymentRequestDto());
		orderFinalResponseDto.setOrderDto(orderDtoResponseDto);
		orderFinalResponseDto.setPaymentResponseDto(paymentResponseDto);
		return orderFinalResponseDto;
	}

	@Override
	public List<OrderDto> getAll() {
		List<Order> orders = orderRepository.findAll();
		List<OrderDto> orderDtos = new ArrayList<>();
		for (Order order : orders) {
			orderDtos.add(mapper.toDTO(order));
		}

		return orderDtos;
	}

	@Override
	public OrderDto get(String orderId) {
		return mapper.toDTO(orderRepository.findById(orderId).get());
	}

	@Override
	public PaymentResponseDto paymentDetails(PaymentRequestDto paymentRequestDto) {
		return paymentService.orderPayment(paymentRequestDto);
	}


	/*
	 * @Override public OrderDto save(OrderDto orderDto) { return
	 * OrderUtilsMapper.INSTANCE.toDto(orderRepository.save(OrderUtilsMapper.
	 * INSTANCE.toEntity(orderDto))); }
	 * 
	 * @Override public List<OrderDto> getAll() { List<Order> orders =
	 * orderRepository.findAll(); List<OrderDto> orderDtos = new ArrayList<>();
	 * for(Order order : orders) {
	 * orderDtos.add(OrderUtilsMapper.INSTANCE.toDto(order)); }
	 * 
	 * return orderDtos; }
	 * 
	 * @Override public OrderDto get(String orderId) { return
	 * OrderUtilsMapper.INSTANCE.toDto(orderRepository.findById(orderId).get()); }
	 */

}
