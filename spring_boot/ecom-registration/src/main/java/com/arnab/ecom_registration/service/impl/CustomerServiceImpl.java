package com.arnab.ecom_registration.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.ecom_registration.dto.AddressDto;
import com.arnab.ecom_registration.dto.CustomerDto;
import com.arnab.ecom_registration.dto.FullCustomerRequestDto;
import com.arnab.ecom_registration.dto.FullCustomerResponseDto;
import com.arnab.ecom_registration.dto.LoginDto;
import com.arnab.ecom_registration.entity.Customer;
import com.arnab.ecom_registration.repository.CustomerRepository;
import com.arnab.ecom_registration.service.AddressService;
import com.arnab.ecom_registration.service.CustomerService;
import com.arnab.ecom_registration.service.LoginService;
import com.arnab.ecom_registration.utils.RegistrationUtils;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private RegistrationUtils registrationUtils;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private AddressService addressService;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public CustomerDto save(CustomerDto customerDto) {
		CustomerDto customer = registrationUtils.entityToDto(customerRepository.save(registrationUtils.dtoToentity(customerDto)));
		customer.setLoginDto(loginService.save(customerDto.getLoginDto()));
		customer.setAddressDto(addressService.save(customerDto.getAddressDto()));
		return customer;
	}

	@Override
	public List<CustomerDto> getAll() {
		 List<CustomerDto> customerDtoList = registrationUtils.listEntityToDto(customerRepository.findAll());
		 List<AddressDto> addressDtoList = addressService.getAll();
		for(int i=0; i<customerDtoList.size(); i++) {
			customerDtoList.get(i).setAddressDto(addressDtoList.get(i));
		}
		return customerDtoList;
	}

	@Override
	public CustomerDto getById(String cid) {
		Optional<Customer> optional = customerRepository.findById(cid);
		CustomerDto customerDto=null;
		if(optional.isPresent()) {
			customerDto = registrationUtils.entityToDto(optional.get());
		}
		customerDto.setAddressDto(addressService.get(cid));
		return  customerDto;
	}

}
