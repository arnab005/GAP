package com.arnab.ecom_order.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.arnab.ecom_order.dto.OrderDto;
import com.arnab.ecom_order.dto.ProductDto;
import com.arnab.ecom_order.entity.Order;
import com.arnab.ecom_order.entity.Product;

@Component
public class OrderMapperBaseImpl extends BaseMapper<OrderDto, Order> {

	@Override
	public OrderDto toDTO(Order entity) {
		OrderDto orderDto = new OrderDto();
		orderDto.setCustomerId(entity.getCustomerId());
		orderDto.setOrder_Id(entity.getOrder_Id());
		orderDto.setOrderDate(new Date());
		orderDto.setProductDtosList(entity.getProductsList()
				.stream()
				.map(p -> new ProductDto(p.getSkuId(), p.getSkuName(), p.getSkuDetails(), p.getSkuPrice(), p.getSkuType()))
				.toList());
		return orderDto;
	}

	@Override
	public Order toEntity(OrderDto dto) {
		Order order = new Order();
		order.setCustomerId(dto.getCustomerId());
		order.setOrder_Id(generateOrderId());
		order.setOrderDate(new Date());
		order.setProductsList(dto.getProductDtosList()
				.stream()
				.map(p -> new Product(p.getSkuId(), p.getSkuName(), p.getSkuDetails(), p.getSkuPrice(), p.getSkuType()))
				.toList());
		return order;
	}

	private String generateOrderId() {
		long number = (long)(Math.random() * 90000L);
        return "OR"+number;
	}

}
