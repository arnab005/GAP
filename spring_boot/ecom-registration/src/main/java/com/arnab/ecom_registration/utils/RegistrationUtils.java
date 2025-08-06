package com.arnab.ecom_registration.utils;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arnab.ecom_registration.dto.CustomerDto;
import com.arnab.ecom_registration.entity.Customer;

@Component
public class RegistrationUtils {
	
	@Autowired
	private ModelMapper modelMapper;

	public CustomerDto entityToDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		BeanUtils.copyProperties(customer, customerDto);
		return customerDto;
	}
	
	public Customer dtoToentity(CustomerDto customerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		return customer;
	}
	
	/*
	 * public R genericEntityToDto(T t) { R r = null; BeanUtils.copyProperties(t,
	 * r); return r; }
	 * 
	 * public R genericDtoToentity(T t) { R r = null; BeanUtils.copyProperties(t,
	 * r); return r; }
	 */
	
	
	public List<CustomerDto> listEntityToDto(List<Customer> customers) {
		TypeToken<List<CustomerDto>> typeToken = new TypeToken<>() {};
		return modelMapper.map(customers, typeToken.getType());
	}
	
	public List<Customer> listDtoToEntity(List<CustomerDto> customersDtos) {
		TypeToken<List<Customer>> typeToken = new TypeToken<>() {};
		return modelMapper.map(customersDtos, typeToken.getType());
	}
	
}
