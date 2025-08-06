package com.arnab.ecom_registration.dto;

import java.util.Date;

import jakarta.persistence.Transient;

public class CustomerDto {

	private String cid;
	private String name;
	private Date dob;
	private String sex;
	private AddressDto addressDto;
	private LoginDto loginDto;
	
	public CustomerDto() {
		super();
	}
	
	public CustomerDto(String cid, String name, Date dob, String sex, AddressDto addressDto, LoginDto loginDto) {
		super();
		this.cid = cid;
		this.name = name;
		this.dob = dob;
		this.sex = sex;
		this.addressDto = addressDto;
		this.loginDto = loginDto;
	}
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public AddressDto getAddressDto() {
		return addressDto;
	}
	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}
	public LoginDto getLoginDto() {
		return loginDto;
	}
	public void setLoginDto(LoginDto loginDto) {
		this.loginDto = loginDto;
	}
}
