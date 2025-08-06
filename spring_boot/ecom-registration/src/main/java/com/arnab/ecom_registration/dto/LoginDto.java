package com.arnab.ecom_registration.dto;

public class LoginDto {
	
	private String cid;
	private String userName;
	private String password;
	
	public LoginDto() {
		super();
	}
	
	public LoginDto(String cid, String userName, String password) {
		super();
		this.cid = cid;
		this.userName = userName;
		this.password = password;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
