package com.arnab.ecom_registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.ecom_registration.dto.CustomerDto;
import com.arnab.ecom_registration.service.CustomerService;

@RestController
@RequestMapping("/registration")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/save")
	public CustomerDto save(@RequestBody CustomerDto customerDto) {
		return customerService.save(customerDto);
	}
	
	@GetMapping("/get")
	public CustomerDto get(@RequestParam String cid) {
		return customerService.getById(cid);
	}
	
	@GetMapping("/getAll")
	public List<CustomerDto> getAll() {
		return customerService.getAll();
	}

	
}
