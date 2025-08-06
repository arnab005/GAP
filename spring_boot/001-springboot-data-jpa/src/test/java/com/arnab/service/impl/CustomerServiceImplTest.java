package com.arnab.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.arnab.entity.Customer;
import com.arnab.repository.CustomerRepository;
import com.arnab.service.CustomerServiceImpl;
import com.arnab.service.exception.CustomerNotFoundException;

@SpringBootTest
public class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl userServiceImpl;

	@Mock
	CustomerRepository userRepository;
	
	static Customer user = new Customer();

	@BeforeAll
	public static void setup() {
		user.setCustomerId(123L);
		user.setFirstName("fname");
		user.setLastName("lname");

	}

	@Test
	public void testGetUserByIdForSuccess() throws CustomerNotFoundException {

		Mockito.when(userRepository.findById(123L)).thenReturn(Optional.of(user));
		Customer user = userServiceImpl.getCustomerById(123L);
		assertNotNull(user);
		assertEquals("test", user.getFirstName());
	}

	@Test
	public void testGetUserByIdForNull() throws CustomerNotFoundException {

		Mockito.when(userRepository.findById(123L)).thenReturn(Optional.of(user));

		Customer user = userServiceImpl.getCustomerById(12L);
		assertNull(user);
	}

	@Test
	public void testGetUserByIdForAnyId() throws CustomerNotFoundException {

		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));

		Customer user = userServiceImpl.getCustomerById(876L);
		assertNotNull(user);
	}

	@Test
	@ExceptionHandler(CustomerNotFoundException.class)
	public void testGetUserByIdForException() throws CustomerNotFoundException {
		Mockito.when(userRepository.findById(123L)).thenReturn(Optional.of(user));
		Customer user = userServiceImpl.getCustomerById(876L);
		assertNotNull(user);
	}

	@AfterAll
	public static void tearDown() {
		user = null;
	}

}
