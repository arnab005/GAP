package com.arnab.ecom_dashboard.utils;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.arnab.ecom_dashboard.dto.OrderDto;
import com.arnab.ecom_dashboard.dto.ProductDto;
import com.arnab.ecom_dashboard.entity.Order;
import com.arnab.ecom_dashboard.entity.Product;

@Mapper(componentModel = "spring")
public interface OrderUtilsMapper {

	OrderUtilsMapper INSTANCE = Mappers.getMapper(OrderUtilsMapper.class);
	
	OrderDto toDto(Order order);
	
	Order toEntity (OrderDto orderDto);
	
	ProductDto toDto(Product product);
	
	Product toEntity(ProductDto productDto);
	
}
