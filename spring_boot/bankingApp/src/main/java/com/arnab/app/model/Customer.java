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
public class Customer {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGen")
//	@SequenceGenerator(name = "mySeqGen", sequenceName = "ACCOUNT_NUMBER_SEQ", initialValue = 1000000000, allocationSize = 1)
	public Long accountNumber;
    public String customerName;
    public String sex;
    public Long mobileNumber;
    public String customerAddress;
    public Double balance;
    public Date accountOpeningDate;
    public Date accountClosedDate;
    
	
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
