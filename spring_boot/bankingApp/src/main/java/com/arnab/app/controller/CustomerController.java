package com.arnab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.arnab.app.dto.CustomerDto;
import com.arnab.app.service.CustomerService;

@RestController
@RequestMapping("/user")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/registration")
	public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto) {
		return ResponseEntity.ok(customerService.registerCustomer(customerDto));
	}
}
