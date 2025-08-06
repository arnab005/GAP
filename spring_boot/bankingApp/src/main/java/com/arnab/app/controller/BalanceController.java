package com.arnab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.arnab.app.dto.AccountDto;
import com.arnab.app.service.AccountService;

@RestController
@RequestMapping("/balance")
public class BalanceController<T, R> {
	
	@Autowired
	private AccountService accountService;
	
	@PutMapping("/deposit")
	public ResponseEntity<AccountDto> addBalance(@RequestParam Long accountNumber, @RequestParam Double balance) {
		return ResponseEntity.ok(accountService.addBalance(accountNumber, balance));
	}
	
	@GetMapping("/get/{accNum}")
	public AccountDto fetchBalance(@PathVariable(name = "accNum") Long accountNumber) {
		return accountService.getBalance(accountNumber);
	}
	

	
}
