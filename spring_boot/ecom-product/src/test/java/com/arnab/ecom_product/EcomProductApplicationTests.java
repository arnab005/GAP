package com.arnab.ecom_product;

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

import com.arnab.ecom_product.dto.ProductDto;
import com.arnab.ecom_product.repository.ProductRepository;
import com.arnab.ecom_product.utils.ProductUtils;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class EcomProductApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductUtils productUtils;
	
	@BeforeEach
	void setUp() {
		productRepository.deleteAll();
	}
	
	
	@Test
	void shouldRegisterCustomer() throws Exception {
		
		mockMvc.perform(post("/product/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(getProductDto())))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.skuName").value("Pen"));
	}
	
	@Test
	void shouldReturnAllCustomers() throws Exception {
		productRepository.save(productUtils.dtoToentity(getProductDto()));
		
		mockMvc.perform(get("/product/getAll"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.skuDetails").value("Ball Pen"));
	}
	
	@Test
	void shouldReturnUserById() throws Exception {
		
		productRepository.save(productUtils.dtoToentity(getProductDto()));
		
		mockMvc.perform(get("/product/"+ getProductDto().getSkuId()))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.skuPrice").value(10.50));
		
	}
	
	public ProductDto getProductDto() {
		ProductDto productDto = new ProductDto("sku123", "Pen", "Ball Pen", 10.50, "Normal");
		return productDto;
	}
}
