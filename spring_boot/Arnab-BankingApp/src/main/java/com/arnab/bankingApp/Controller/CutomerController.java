package com.arnab.bankingApp.Controller;

import com.arnab.bankingApp.Dto.CustomerDto;
import com.arnab.bankingApp.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CutomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public Mono<CustomerDto> saveCustomer(@RequestBody Mono<CustomerDto> customerDto){
        return customerService.saveCustomer(customerDto);
    }
}
