package com.arnab.bankingApp.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistory {

    @Id
    public String fromAccountNumber;
    public String fromAccount;
    public String toAccountNumber;
    public String toAccount;
    public Date transactionDate;
    public String referenceNumber;
}
