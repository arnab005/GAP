package com.arnab.ecom_order.utils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.arnab.ecom_order.dto.OrderDto;
import com.arnab.ecom_order.dto.ProductDto;
import com.arnab.ecom_order.entity.Order;
import com.arnab.ecom_order.entity.Product;

public class OrderMapperGenImpl implements GenericMapper<OrderDto, Order> {

	@Override
	public OrderDto toDTO(Order entity) {
		OrderDto orderDto = new OrderDto();
		orderDto.setCustomerId(entity.getCustomerId());
		orderDto.setOrder_Id(entity.getOrder_Id());
		orderDto.setOrderDate(new Date());
		orderDto.setProductDtosList(entity.getProductsList()
				.stream()
				.map(p -> new ProductDto(p.getSkuId(), p.getSkuName(), p.getSkuDetails(), p.getSkuPrice(), p.getSkuType()))
				.collect(Collectors.toList()));
		return orderDto;
	}

	@Override
	public Order toEntity(OrderDto dto) {
		Order order = new Order();
		order.setCustomerId(dto.getCustomerId());
		order.setOrder_Id(dto.getOrder_Id());
		order.setOrderDate(new Date());
		order.setProductsList(dto.getProductDtosList()
				.stream()
				.map(product -> new Product(product.getSkuId(), product.getSkuName(), product.getSkuDetails(), product.getSkuPrice(), product.getSkuType()))
				.collect(Collectors.toList()));
		
		return order;
	}

	@Override
	public List<OrderDto> toDTO(List<Order> entityList) {
		
		return entityList.stream().map(this::toDTO).toList();
	}

	@Override
	public List<Order> toEntity(List<OrderDto> dtoList) {
		return dtoList.stream().map(this::toEntity).toList();
	}

	
}
