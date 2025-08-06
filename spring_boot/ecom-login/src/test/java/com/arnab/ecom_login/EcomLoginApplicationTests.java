package com.arnab.ecom_login;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import com.arnab.ecom_login.dto.LoginDto;
import com.arnab.ecom_login.repository.LoginRepository;
import com.arnab.ecom_login.utils.LoginUtils;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class EcomLoginApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private LoginUtils loginUtils;
	
	@BeforeEach
	void setUp() {
		loginRepository.deleteAll();
	}
	
	
	//@Test
	void shouldRegisterCustomer() throws Exception {
		
		mockMvc.perform(post("/login/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(getLoginDto())))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.userName").value("Arnab"));
	}
	
	//@Test
	void shouldReturnAllCustomers() throws Exception {
		loginRepository.save(loginUtils.dtoToentity(getLoginDto()));
		
		mockMvc.perform(get("/login/getAll"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.cid").value("c123"));
	}
	
	//@Test
	void shouldReturnUserById() throws Exception {
		
		loginRepository.save(loginUtils.dtoToentity(getLoginDto()));
		
		mockMvc.perform(get("/login/"+ getLoginDto().getCid()))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.userName").value("Arnab"));
		
	}
	
	public LoginDto getLoginDto() {
		LoginDto loginDto = new LoginDto("c123", "Arnab", "Arnab123");
		return loginDto;
	}
}
