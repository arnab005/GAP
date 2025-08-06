package com.arnab.ecom_registration.dto;

public class FullCustomerRequestDto {
	
	private CustomerDto customerDto;
	private AddressDto addressDto;
	private LoginDto loginDto;
	
	
	public CustomerDto getCustomerDto() {
		return customerDto;
	}
	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
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
