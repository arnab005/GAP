package com.arnab.app.service;

import java.util.Date;
import java.util.List;

import com.arnab.app.dto.TransactionHistoryDto;
import com.arnab.app.dto.TransactionHistoryResponseDto;

public interface TransactionHistoryService {

	public List<TransactionHistoryDto> statement(Long fromAccountNumber, Date fromDate, Date toDate);
	
	public TransactionHistoryResponseDto fundTransfer(TransactionHistoryDto transactionHistoryDto);
}
