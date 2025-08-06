package com.arnab.bankingApp.utils;

import com.arnab.bankingApp.Dto.CustomerDto;
import com.arnab.bankingApp.Entity.Customer;
import org.springframework.beans.BeanUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class AppUtils {

    public static CustomerDto entityToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    public static Customer dtoToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }

    public static CustomerDto accountNumber(CustomerDto customerDto){
       customerDto.setAccountNumber(new DecimalFormat("0000000000")
                .format(new Random().nextLong(9999999999L)));
       return customerDto;
    }
}
