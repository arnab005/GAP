package com.arnab.ecom_cart;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import com.arnab.ecom_cart.dto.CartDto;
import com.arnab.ecom_cart.dto.ProductDto;
import com.arnab.ecom_cart.repository.CartRepository;
import com.arnab.ecom_cart.utils.CartUtils;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class EcomCartApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartUtils cartUtils;
	
	@BeforeEach
	void setUp() {
		cartRepository.deleteAll();
	}
	
	
	@Test
	void shouldRegisterCustomer() throws Exception {
		
		mockMvc.perform(post("/cart/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(getCartDto())))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.state").value("WB"));
	}
	
	@Test
	void shouldReturnAllCustomers() throws Exception {
		cartRepository.save(cartUtils.dtoToentity(getCartDto()));
		
		mockMvc.perform(get("/cart/getAll"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.pinCode").value(700135L));
	}
	
	@Test
	void shouldReturnUserById() throws Exception {
		
		cartRepository.save(cartUtils.dtoToentity(getCartDto()));
		
		mockMvc.perform(get("/cart/"+ getCartDto().getCid()))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.street1").value("Shapoorji"));
		
	}
	
	public CartDto getCartDto() {
		ProductDto productDto = new ProductDto("sku123", "Paper", "A4 Paper", 15.10, "Normal", 10L);
		List<ProductDto> productDtos = new ArrayList<>();
		productDtos.add(productDto);
		CartDto cartDto = new CartDto("c123", productDtos);
		return cartDto;
	}
}
