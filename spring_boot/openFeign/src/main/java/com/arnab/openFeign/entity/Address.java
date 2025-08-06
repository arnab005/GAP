package com.arnab.openFeign.entity;

import org.springframework.data.annotation.Id;


public class Address {

	@Id
	private String street1;
	private String street2;
	private String district;
	private Long pincode;
	private String state;
	
	
}
