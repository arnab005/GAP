package com.arnab.ecom_order;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.arnab.ecom_order.dto.OrderDto;
import com.arnab.ecom_order.dto.PaymentRequestDto;
import com.arnab.ecom_order.dto.ProductDto;
import com.arnab.ecom_order.entity.Order;
import com.arnab.ecom_order.repository.OrderRepository;
import com.arnab.ecom_order.utils.GenericMapper;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class EcomOrderApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private GenericMapper<OrderDto, Order> orderUtils;
	
	@BeforeEach
	void setUp() {
		orderRepository.deleteAll();
	}
	
	
	@Test
	void shouldRegisterCustomer() throws Exception {
		
		mockMvc.perform(post("/order/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(getOrderDto())))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.skuId").value("sku123"));
	}
	
	@Test
	void shouldReturnAllCustomers() throws Exception {
		orderRepository.save(orderUtils.toEntity(getOrderDto()));
		
		mockMvc.perform(get("/order/getAll"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.skuName").value("Paper"));
	}
	
	@Test
	void shouldReturnUserById() throws Exception {
		
		orderRepository.save(orderUtils.toEntity(getOrderDto()));
		
		mockMvc.perform(get("/order/"+ getOrderDto().getOrder_Id()))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.skuPrice").value(15.10));
		
	}
	
	public OrderDto getOrderDto() {
		ProductDto productDto = new ProductDto("sku123", "Paper", "A4 Paper", 15.10, "Normal");
		List<ProductDto> productDtos = new ArrayList<>();
		productDtos.add(productDto);
		PaymentRequestDto paymentRequestDto = new PaymentRequestDto(1111111L, 250.50, 22222222L);
		
		OrderDto orderDto = new OrderDto("c123", "OR123", productDtos, new Date(), paymentRequestDto);
		return orderDto;
	}
}
