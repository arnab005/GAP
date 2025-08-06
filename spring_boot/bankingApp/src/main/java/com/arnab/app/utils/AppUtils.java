package com.arnab.app.utils;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;

import com.arnab.app.dto.AccountDto;
import com.arnab.app.dto.CustomerDto;
import com.arnab.app.dto.TransactionHistoryDto;
import com.arnab.app.model.Account;
import com.arnab.app.model.Customer;
import com.arnab.app.model.TransactionHistory;


public class AppUtils {
	
	public static Double DEFAULT_BALANCE = 10000.00;
	
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
	
	public static TransactionHistoryDto entityToDto(Optional<TransactionHistory> transactionHistory) {
		TransactionHistoryDto transactionHistoryDto = new TransactionHistoryDto();
		BeanUtils.copyProperties(transactionHistory, transactionHistoryDto);
		return transactionHistoryDto;
	}
	
	public static TransactionHistory dtoToEntity(TransactionHistoryDto transactionHistoryDto) {
		TransactionHistory transactionHistory = new TransactionHistory();
		BeanUtils.copyProperties(transactionHistoryDto, transactionHistory);
		return transactionHistory;
	}
	
	public static AccountDto entityToDto(Account account) {
		AccountDto accountDto = new AccountDto();
		BeanUtils.copyProperties(account, accountDto);
		return accountDto;
	}
	
	public static Account dtoToEntity(AccountDto accountDto) {
		Account account = new Account();
		BeanUtils.copyProperties(accountDto, account);
		return account;
	}
	
	public static List<TransactionHistoryDto> listEntityToDto(List<TransactionHistory> transactionHistories){
		ModelMapper modelMapper = new ModelMapper();
		TypeToken<List<TransactionHistoryDto>> typeToken = new TypeToken<>(){};
		List<TransactionHistoryDto> transactionHistoryDtos = modelMapper.map(transactionHistories, typeToken.getType());
		return transactionHistoryDtos;
	}
	
}
