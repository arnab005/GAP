package com.arnab.ecom_order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.ecom_order.dto.OrderDto;
import com.arnab.ecom_order.dto.OrderFinalResponseDto;
import com.arnab.ecom_order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/save")
	public OrderFinalResponseDto save(@RequestBody OrderDto orderDto) {
		return orderService.save(orderDto);
	}
	
	@GetMapping("/get")
	public OrderDto get(@RequestParam String orderId) {
		return orderService.get(orderId);
	}
	
	@GetMapping("/getAll")
	public List<OrderDto> getAll() {
		return orderService.getAll();
	}
	
}
