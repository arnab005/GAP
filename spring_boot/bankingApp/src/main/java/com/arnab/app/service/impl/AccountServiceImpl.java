package com.arnab.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.app.dto.AccountDto;
import com.arnab.app.repository.AccountRespository;
import com.arnab.app.service.AccountService;
import com.arnab.app.utils.AppUtils;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRespository accountRespository;
	
	@Override
	public AccountDto getBalance(Long accountId) {
		AccountDto accountDto = AppUtils.entityToDto(accountRespository.findById(accountId).get());
		accountDto.setStatusMessage("Current Account balance is Rs: " + accountDto.getAccountBalance());
		return accountDto;
	}

	@Override
	public AccountDto addBalance(Long accountId, Double amount) {
		AccountDto accountDto = AppUtils.entityToDto(accountRespository.findById(accountId).get());
		accountDto.setAccountBalance(accountDto.getAccountBalance() + amount);
		accountDto = AppUtils.entityToDto(accountRespository.save(AppUtils.dtoToEntity(accountDto)));
		accountDto.setStatusMessage("Amount Added Rs: " + amount + " successfully");
		return accountDto;
	}

	@Override
	public AccountDto updateBalance(Long accountNumber, Double accountBalance) {
		AccountDto accountDto = AppUtils.entityToDto(accountRespository.findById(accountNumber).get());
		accountDto.setAccountBalance(accountBalance);
		return AppUtils.entityToDto(accountRespository.save(AppUtils.dtoToEntity(accountDto)));
	}
	
	@Override
	public AccountDto initialBalance(Long accountNumber, Double accountBalance) {
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountNumber(accountNumber);
		accountDto.setAccountBalance(accountBalance);
		return AppUtils.entityToDto(accountRespository.save(AppUtils.dtoToEntity(accountDto)));
	}
	
	

}
