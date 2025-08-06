package com.arnab.ecom_dashboard.service;

import java.util.List;

import com.arnab.ecom_dashboard.dto.OrderDto;

public interface DashboardService {

	public List<OrderDto> getAll();
	
	public OrderDto get(String orderId);
}
