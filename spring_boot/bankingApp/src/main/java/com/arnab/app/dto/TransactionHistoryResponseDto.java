package com.arnab.app.dto;

import com.arnab.app.model.Status;

public class TransactionHistoryResponseDto {

	String message;
	Status status;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
