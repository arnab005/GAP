package com.arnab.ecom_registration.service;

import java.util.List;

import com.arnab.ecom_registration.dto.CustomerDto;

public interface CustomerService {
	
	public CustomerDto save(CustomerDto customerDto);
	
	public List<CustomerDto> getAll();
	
	public CustomerDto getById(String cid);

}
