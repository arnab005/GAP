package com.arnab.app.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.app.dto.AccountDto;
import com.arnab.app.dto.TransactionHistoryDto;
import com.arnab.app.dto.TransactionHistoryResponseDto;
import com.arnab.app.model.Status;
import com.arnab.app.model.TransactionHistory;
import com.arnab.app.repository.TransactionHistoryRepository;
import com.arnab.app.service.TransactionHistoryService;
import com.arnab.app.utils.AppUtils;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {
	
	@Autowired
	private TransactionHistoryRepository transactionHistoryRepository;
	
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	@Override
	public List<TransactionHistoryDto> statement(Long fromAccountNumber, Date fromDate, Date toDate) {
		return AppUtils.listEntityToDto(transactionHistoryRepository.findByFromAccountNumber(fromAccountNumber));
	}

	@Override
	public TransactionHistoryResponseDto fundTransfer(TransactionHistoryDto transactionHistoryDto) {
		AccountDto fromAccountDto = accountServiceImpl.getBalance(transactionHistoryDto.getFromAccountNumber());
		Double fromAccountBalance = fromAccountDto.getAccountBalance();
		Double transferAmout =  transactionHistoryDto.getTransferAmount();
		
		
		AccountDto toAccountDto = accountServiceImpl.getBalance(transactionHistoryDto.getToAccountNumber());
		Double toAccountBalance = toAccountDto.getAccountBalance();
		
		TransactionHistoryResponseDto transactionHistoryResponseDto = new TransactionHistoryResponseDto();
		transactionHistoryDto.setTransactionDate(new Date());
		if( fromAccountBalance > AppUtils.DEFAULT_BALANCE) {
			if(fromAccountBalance - transferAmout >= AppUtils.DEFAULT_BALANCE ) {
				fromAccountBalance -=  transferAmout;
				toAccountBalance += transferAmout; 
				transactionHistoryDto.setDebitedAmount(transferAmout);
				transactionHistoryDto.setCreditedAmount(transferAmout);
				accountServiceImpl.updateBalance(fromAccountDto.getAccountNumber(), fromAccountBalance);
				accountServiceImpl.updateBalance(toAccountDto.getAccountNumber(), toAccountBalance);
				transactionHistoryResponseDto.setMessage("You have transfered Rs " + transferAmout + " successfully to " + toAccountDto.getAccountNumber());
				transactionHistoryResponseDto.setStatus(Status.SUCCESS);
				transactionHistoryRepository.save(AppUtils.dtoToEntity(transactionHistoryDto));
			}else {
				fromAccountBalance -= transferAmout;
				toAccountBalance += transferAmout;
				transactionHistoryDto.setDebitedAmount(transferAmout);
				transactionHistoryDto.setCreditedAmount(transferAmout);
				accountServiceImpl.updateBalance(fromAccountDto.getAccountNumber(), fromAccountBalance);
				accountServiceImpl.updateBalance(toAccountDto.getAccountNumber(), toAccountBalance);
				transactionHistoryResponseDto.setMessage("Your balance is below MAB, Kindly maintain sufficient balance.");
				transactionHistoryResponseDto.setStatus(Status.MAINTAIN_BALANCE);
				transactionHistoryRepository.save(AppUtils.dtoToEntity(transactionHistoryDto));
			}
		}else {
			transactionHistoryResponseDto.setMessage("You don't have sufficient balance for the current transaction, Kindly maintain sufficient balance");
			transactionHistoryResponseDto.setStatus(Status.INSUFFICIENT_BALANCE);
		}
		return transactionHistoryResponseDto;
	}

}
