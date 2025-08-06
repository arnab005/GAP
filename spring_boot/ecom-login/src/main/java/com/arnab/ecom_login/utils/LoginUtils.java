package com.arnab.ecom_login.utils;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arnab.ecom_login.dto.LoginDto;
import com.arnab.ecom_login.entity.Login;

@Component
public class LoginUtils {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public LoginDto entityToDto(Login login) {
		return modelMapper.map(login, LoginDto.class);
	}
	
	public Login dtoToentity(LoginDto loginDto) {
		return modelMapper.map(loginDto, Login.class);
	}
	
	public List<LoginDto> listEntityToDto(List<Login> logins) {
		TypeToken<List<LoginDto>> typeToken = new TypeToken<>() {};
		return modelMapper.map(logins, typeToken.getType());
	}
	
	public List<Login> listDtoToEntity(List<LoginDto> loginDtos) {
		TypeToken<List<Login>> typeToken = new TypeToken<>() {};
		return modelMapper.map(loginDtos, typeToken.getType());
	}

}
