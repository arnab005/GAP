package com.arnab.ecom_dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.ecom_dashboard.dto.OrderDto;
import com.arnab.ecom_dashboard.entity.Order;
import com.arnab.ecom_dashboard.repository.DashboardRepository;
import com.arnab.ecom_dashboard.service.DashboardService;
import com.arnab.ecom_dashboard.utils.GenericMapper;
import com.arnab.ecom_dashboard.utils.OrderUtilsMapper;

@Service
public class DashBoardServiceImpl implements DashboardService {

//	@Autowired
//	private OrderUtilsMapper orderUtilsMapper;
	
	@Autowired
	private GenericMapper<OrderDto, Order> genericMapper;
	
	@Autowired
	private DashboardRepository dashboardRepository;

	@Override
	public List<OrderDto> getAll() {
		List<Order> orders = dashboardRepository.findAll();
		List<OrderDto> orderDtos = new ArrayList<>();
		for(Order order : orders) {
			orderDtos.add(genericMapper.toDTO(order));
		}
		
		return orderDtos;
	}

	@Override
	public OrderDto get(String orderId) {
		return genericMapper.toDTO(dashboardRepository.findById(orderId).get());
	}
	
//	@Override
//	public List<OrderDto> getAll() {
//		List<Order> orders = dashboardRepository.findAll();
//		List<OrderDto> orderDtos = new ArrayList<>();
//		for(Order order : orders) {
//			orderDtos.add(orderUtilsMapper.INSTANCE.toDto(order));
//		}
//		
//		return orderDtos;
//	}
//
//	@Override
//	public OrderDto get(String orderId) {
//		return orderUtilsMapper.INSTANCE.toDto(dashboardRepository.findById(orderId).get());
//	}

}
