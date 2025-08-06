package com.arnab.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.app.dto.TransactionHistoryDto;
import com.arnab.app.dto.TransactionHistoryResponseDto;
import com.arnab.app.model.TransactionHistory;
import com.arnab.app.repository.TransactionHistoryRepository;
import com.arnab.app.service.TransactionHistoryService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionHistoryService transactionHistoryService;
	
	@PostMapping("/transfer")
	public TransactionHistoryResponseDto fundTransfer(@RequestBody TransactionHistoryDto transactionHistoryDto) {
		return transactionHistoryService.fundTransfer(transactionHistoryDto);
	}
	
	@GetMapping("/statement")
	public List<TransactionHistoryDto> getStatement(@RequestParam Long accountNumber) {
		return transactionHistoryService.statement(accountNumber, new Date(), new Date());
	}
}
