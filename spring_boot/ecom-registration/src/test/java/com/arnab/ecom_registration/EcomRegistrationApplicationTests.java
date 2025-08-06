package com.arnab.ecom_registration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.arnab.ecom_registration.dto.AddressDto;
import com.arnab.ecom_registration.dto.CustomerDto;
import com.arnab.ecom_registration.dto.LoginDto;
import com.arnab.ecom_registration.entity.Customer;
import com.arnab.ecom_registration.repository.CustomerRepository;
import com.arnab.ecom_registration.utils.RegistrationUtils;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class EcomRegistrationApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RegistrationUtils registrationUtils;
	
	@BeforeEach
	void setUp() {
		customerRepository.deleteAll();
	}
	
	
	@Test
	void shouldRegisterCustomer() throws Exception {
		
		mockMvc.perform(post("/registration/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(getCustomer())))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("Arnab"));
	}
	
	@Test
	void shouldReturnAllCustomers() throws Exception {
		CustomerDto customerDto = getCustomer();
		customerRepository.save(registrationUtils.dtoToentity(getCustomer()));
		
		mockMvc.perform(get("/registration/getAll"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.sex").value("M"));
	}
	
	@Test
	void shouldReturnUserById() throws Exception {
		CustomerDto customerDto = getCustomer();
		customerRepository.save(registrationUtils.dtoToentity(getCustomer()));
		
		mockMvc.perform(get("/registration/"+customerDto.getCid()))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("Arnab"));
		
	}
	
	public CustomerDto getCustomer() {
		Date date = new Date();
		AddressDto addressDto = new AddressDto("c123", "Shapoorji", "Newtown", 700135L, "WB");
		LoginDto loginDto = new LoginDto("c123", "abc123", "123");
		CustomerDto customerDto = new CustomerDto("c123", "Arnab", date, "M", addressDto, loginDto);
		return customerDto;
	}
}
