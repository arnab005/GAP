package com.arnab.ecom_registration.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.arnab.ecom_registration.dto.AddressDto;
import com.arnab.ecom_registration.dto.LoginDto;

@FeignClient(name = "addressService", url = "http://localhost:8081/address")
public interface AddressService {

	@PostMapping("/save")
	public AddressDto save(@RequestBody AddressDto addressDto);
	
	@GetMapping("/get")
	public AddressDto get(@RequestParam String cid);
	
	@GetMapping("/getAll")
	public List<AddressDto> getAll();

}
