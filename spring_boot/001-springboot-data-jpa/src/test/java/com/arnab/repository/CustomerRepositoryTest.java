package com.arnab.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository userRepository;
	
	@Test
	public void testGetCustomUser() {
		//List<UserResponseDto> userResponseDtos = userRepository.getCustomUser("fname1");
		
		
	}
}
