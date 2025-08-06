package com.arnab.ecom_login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.ecom_login.dto.LoginDto;
import com.arnab.ecom_login.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/save")
	public ResponseEntity<LoginDto> save(@RequestBody LoginDto loginDto) {
		return new ResponseEntity<>(loginService.save(loginDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<LoginDto> get(@RequestParam String cid) {
		return new ResponseEntity<LoginDto>(loginService.getById(cid), HttpStatus.OK) ;
	}
	
//	@GetMapping("/getAll")
//	public List<LoginDto> getAll() {
//		return loginService.getAll();
//	}
	
	@PostMapping("/logIn")
	public ResponseEntity<String> login(LoginDto loginDto) {
		return new ResponseEntity<String>(loginService.loggedIn(loginDto), HttpStatus.OK);
	}
	
}
