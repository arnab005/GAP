package com.arnab.ecom_login.service;

import java.util.List;

import com.arnab.ecom_login.dto.LoginDto;

public interface LoginService {

public LoginDto save(LoginDto loginDto);
	
	public LoginDto getById(String cid);

	//public List<LoginDto> getAll();
	
	public String loggedIn(LoginDto loginDto);
}
