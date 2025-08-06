package com.arnab.app.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistoryDto {

	@JsonProperty(access = Access.READ_ONLY)
	public Long referenceNumber;
	public Long fromAccountNumber;
	public Double transferAmount;
    @JsonIgnore
	public Double debitedAmount;
    public Long toAccountNumber;
    @JsonIgnore
    public Double creditedAmount;
    @JsonIgnore
    public Date transactionDate;
    
    public synchronized final Long getReferenceNumber() {
		return referenceNumber;
	}
	public synchronized final Long getFromAccountNumber() {
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

	public void setReferenceNumber(Long referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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
	public Double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}
}
