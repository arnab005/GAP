package com.arnab.ecom_registration.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {

	@Id
	private String cid;
	private String name;
	private Date dob;
	private String sex;
//	private Login loginDetails;
//	private Address address;
	
	public Customer() {
		super();
	}
	
	public Customer(String cid, String name, Date dob, String sex) {
		super();
		this.cid = cid;
		this.name = name;
		this.dob = dob;
		this.sex = sex;
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
//	public Login getLoginDetails() {
//		return loginDetails;
//	}
//	public void setLoginDetails(Login loginDetails) {
//		this.loginDetails = loginDetails;
//	}
//	public Address getAddress() {
//		return address;
//	}
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	
}
