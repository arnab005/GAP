package com.arnab.ecom_registration.dto;

public class FullCustomerResponseDto {
	
	private CustomerDto customerDto;
	private AddressDto addressDto;
	
	
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
	
	
	

}
