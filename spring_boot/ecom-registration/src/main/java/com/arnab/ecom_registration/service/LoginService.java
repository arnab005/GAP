package com.arnab.ecom_registration.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arnab.ecom_registration.dto.LoginDto;

@FeignClient(name = "logInService", url = "http://localhost:8082/login")
public interface LoginService {
	
	@PostMapping("/save")
	public LoginDto save(LoginDto loginDto);
	
	@GetMapping("/get")
	public LoginDto get(String customerId);
	
	@GetMapping("/getAll")
	public List<LoginDto> get();

	
}
