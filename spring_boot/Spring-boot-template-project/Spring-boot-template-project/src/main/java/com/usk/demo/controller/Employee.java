package com.usk.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class Employee {
	
	@GetMapping("/message")
	public String getMessage() {
		return "Hello from Spring Boot Application.";
	}

}
