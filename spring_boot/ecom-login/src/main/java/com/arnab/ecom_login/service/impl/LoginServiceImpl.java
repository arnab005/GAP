package com.arnab.ecom_login.service.impl;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.arnab.ecom_login.dto.LoginDto;
import com.arnab.ecom_login.entity.Login;
import com.arnab.ecom_login.exception.UserNotFoundException;
import com.arnab.ecom_login.repository.LoginRepository;
import com.arnab.ecom_login.service.LoginService;
import com.arnab.ecom_login.utils.LoginUtils;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginUtils loginUtils;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public LoginDto save(LoginDto loginDto) {
		return loginUtils.entityToDto(loginRepository.save(loginUtils.dtoToentity(loginDto)));
	}

	@Override
	public LoginDto getById(String cid) {
		Optional<Login> optional = loginRepository.findById(cid);
		return  optional.isPresent()? loginUtils.entityToDto(optional.get()) : loginUtils.entityToDto(optional.orElseThrow());
	}

//	@Override
//	public List<LoginDto> getAll() {
//		return loginUtils.listEntityToDto(loginRepository.findAll());
//	}

	@Override
	public String loggedIn(LoginDto loginDto) {
		String userName = loginDto.getUserName();
		String password = loginDto.getPassword();
		Login login = loginRepository.findByUserName(userName);
		String savedPassword = login.getPassword();
		if(savedPassword == null || savedPassword.isEmpty()) {
			throw new UserNotFoundException(userName);
		} else if(login.getPassword().equals(password)) {
			String token = generateTokenForValidUser(userName, password);
			return String.format(" Logged is successfully with userName %s ." , loginDto.getUserName());
		} else {
			return String.format(" Password is not valid, Please try again with userName %s ." , loginDto.getUserName());
		}
	}

	private String generateTokenForValidUser(String userName, String password) {
		
		return null;
	}

}
