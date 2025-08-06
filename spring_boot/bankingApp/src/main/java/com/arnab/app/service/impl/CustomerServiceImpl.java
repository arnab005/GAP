package com.arnab.app.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.app.dto.CustomerDto;
import com.arnab.app.repository.CustomerRepository;
import com.arnab.app.service.CustomerService;
import com.arnab.app.utils.AppUtils;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	@Override
	public CustomerDto registerCustomer(CustomerDto customerDto) {
		customerDto.setBalance(AppUtils.DEFAULT_BALANCE);
		customerDto.setAccountOpeningDate(new Date());
		customerDto.setAccountNumber(generateUniqueRandomNumber());
		CustomerDto custDto = AppUtils.entityToDto(customerRepository.save(AppUtils.dtoToEntity(customerDto)));
		accountServiceImpl.initialBalance(custDto.getAccountNumber(),customerDto.getBalance());
		return custDto;  
	}
	
	public static Long generateUniqueRandomNumber() {
        long number = (long)(Math.random() * 9000000000L) + 1000000000L;
        return number;
    }

}
