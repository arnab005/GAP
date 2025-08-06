package com.arnab.app.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGen")
	@SequenceGenerator(name = "mySeqGen", sequenceName = "REFERENCE_NUMBER_SEQ", initialValue = 9999, allocationSize = 1)
	public Long referenceNumber;
	public Long fromAccountNumber;
	public Double transferAmount;
    public Double debitedAmount;
    public Long toAccountNumber;
    public Double creditedAmount;
    public Date transactionDate;
    
    
	
	public Long getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(Long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	public Long getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(Long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public synchronized final Long getReferenceNumber() {
		return referenceNumber;
	}
	public synchronized final void setReferenceNumber(Long referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public Double getDebitedAmount() {
		return debitedAmount;
	}
	public void setDebitedAmount(Double debitedAmount) {
		this.debitedAmount = debitedAmount;
	}
	public Double getCreditedAmount() {
		return creditedAmount;
	}
	public void setCreditedAmount(Double creditedAmount) {
		this.creditedAmount = creditedAmount;
	}
	public final Double getTransferAmount() {
		return transferAmount;
	}
	public final void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}
}
