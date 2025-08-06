package com.arnab.ecom_order.utils;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.arnab.ecom_order.dto.OrderDto;
import com.arnab.ecom_order.dto.ProductDto;
import com.arnab.ecom_order.entity.Order;
import com.arnab.ecom_order.entity.Product;

@Mapper
public interface OrderUtilsMapper {

	OrderUtilsMapper INSTANCE = Mappers.getMapper(OrderUtilsMapper.class);
	
	OrderDto toDto(Order order);
	
	Order toEntity (OrderDto orderDto);
	
	ProductDto toDto(Product product);
	
	Product toEntity(ProductDto productDto);
	
}
