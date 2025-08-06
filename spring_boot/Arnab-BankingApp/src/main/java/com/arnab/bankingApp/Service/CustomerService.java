package com.arnab.bankingApp.Service;

import com.arnab.bankingApp.Dto.CustomerDto;
import com.arnab.bankingApp.Entity.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

public interface CustomerService {

    public Mono<CustomerDto> saveCustomer(Mono<CustomerDto> customerDto);
}
