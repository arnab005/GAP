package com.arnab.openFeign.dto;

import com.arnab.openFeign.entity.Address;

public class StudentDto {
	
	
	private Long sid;
	private String sname;
	private Address address;
	
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
//	public Address getAddress() {
//		return address;
//	}
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	
	
	
}
