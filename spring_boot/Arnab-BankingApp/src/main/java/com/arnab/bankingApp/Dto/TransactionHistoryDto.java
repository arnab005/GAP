package com.arnab.bankingApp.Dto;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TransactionHistoryDto {

    public String fromAccountNumber;
    public String fromAccount;
    public String toAccountNumber;
    public String toAccount;
    public Date transactionDate;
    public String referenceNumber;
}
