package com.arnab.ecom_login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Login {

	@Id
	private String cid;
	private String userName;
	private String password;
	
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
