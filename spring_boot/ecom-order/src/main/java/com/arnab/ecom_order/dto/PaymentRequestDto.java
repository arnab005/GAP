package com.arnab.ecom_order.dto;

public class PaymentRequestDto {
	
	private Long fromAccountNumber;
	private Double transferAmount;
	private Long toAccountNumber;
	
	public PaymentRequestDto() {
		super();
	}
	
	public PaymentRequestDto(Long fromAccountNumber, Double transferAmount, Long toAccountNumber) {
		super();
		this.fromAccountNumber = fromAccountNumber;
		this.transferAmount = transferAmount;
		this.toAccountNumber = toAccountNumber;
	}
	
	public Long getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(Long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	public Double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}
	public Long getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(Long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
}
