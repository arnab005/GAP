package com.arnab.ecom_dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.ecom_dashboard.dto.OrderDto;
import com.arnab.ecom_dashboard.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;
	
	
	@GetMapping("/get")
	public OrderDto get(@RequestParam String orderId) {
		return dashboardService.get(orderId);
	}
	
	@GetMapping("/getAll")
	public List<OrderDto> getAll() {
		return dashboardService.getAll();
	}
}
