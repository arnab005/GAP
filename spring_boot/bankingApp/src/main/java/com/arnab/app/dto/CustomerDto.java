package com.arnab.app.dto;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	
	@JsonIgnore
	private Long accountNumber;
	private String customerName;
	private String sex;
    private Long mobileNumber;
	private String customerAddress;
	@JsonProperty(access = Access.READ_ONLY)
	private Double balance;
	@JsonProperty(access = Access.READ_ONLY)
	private Date accountOpeningDate;
	@JsonIgnore
	private Date accountClosedDate;
    
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public Date getAccountOpeningDate() {
		return accountOpeningDate;
	}
	public void setAccountOpeningDate(Date accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}
	public Date getAccountClosedDate() {
		return accountClosedDate;
	}
	public void setAccountClosedDate(Date accountClosedDate) {
		this.accountClosedDate = accountClosedDate;
	}
	public final Double getBalance() {
		return balance;
	}
	public final void setBalance(Double balance) {
		this.balance = balance;
	}
}
