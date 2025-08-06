package com.arnab.app.service;

import com.arnab.app.dto.AccountDto;

public interface AccountService {

	public AccountDto getBalance(Long accountId);
	
	public AccountDto addBalance(Long accountId, Double amount);
	
	public AccountDto initialBalance(Long accountNumber, Double accountBalance);

	public AccountDto updateBalance(Long accountNumber, Double accountBalance);
}
