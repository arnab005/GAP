package com.arnab.ecom_order.utils;

import org.mapstruct.Mapper;

import com.arnab.ecom_order.dto.OrderDto;
import com.arnab.ecom_order.entity.Order;

@Mapper(componentModel = "spring")
public interface ProductMapStructMapper extends GenericMapStructMapper<OrderDto, Order> {

}
