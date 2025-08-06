package com.arnab.bankingApp.Service.Impl;

import com.arnab.bankingApp.Dto.CustomerDto;
import com.arnab.bankingApp.Repository.CustomerRepository;
import com.arnab.bankingApp.Service.CustomerService;
import com.arnab.bankingApp.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Mono<CustomerDto> saveCustomer(Mono<CustomerDto> customerDto) {
        return customerDto
                .map(AppUtils::accountNumber)
                .map(AppUtils::dtoToEntity)
                .flatMap(customerRepository::save)
                .map(AppUtils::entityToDto);
    }
}
