package com.arnab.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arnab.entity.Customer;
import com.arnab.service.CustomerServiceImpl;
import com.arnab.service.exception.CustomerNotFoundException;

@SpringBootTest
public class CustomerServiceImplTest2 {
	
	@Autowired
	CustomerServiceImpl userServiceImpl;

	@Test
	public void testGetUserByIdForSuccess() throws CustomerNotFoundException {

		Customer user = userServiceImpl.getUserById(5L);
		assertNotNull(user);
		assertEquals("test", user.getFirstName());
		System.out.println(user.getFirstName());
		//assertEquals("test", user.getFirstName());
	}

}
