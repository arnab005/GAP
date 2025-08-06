package com.arnab.ecom_address.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document
public class Address {
	
	@Id
	private String cid;
	private String street1;
	private String street2;
	private Long pinCode;
	private String state;
	
	@Builder
	public Address(String cid, String street1, String street2, Long pinCode, String state) {
		this.cid = cid;
		this.street1 = street1;
		this.street2 = street2;
		this.pinCode = pinCode;
		this.state = state;
	}
	
//	public String getCid() {
//		return cid;
//	}
//	public void setCid(String cid) {
//		this.cid = cid;
//	}
//	public String getStreet1() {
//		return street1;
//	}
//	public void setStreet1(String street1) {
//		this.street1 = street1;
//	}
//	public String getStreet2() {
//		return street2;
//	}
//	public void setStreet2(String street2) {
//		this.street2 = street2;
//	}
//	public Long getPinCode() {
//		return pinCode;
//	}
//	public void setPinCode(Long pinCode) {
//		this.pinCode = pinCode;
//	}
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
}
