package com.arnab.ecom_order.utils;

import org.mapstruct.Mapper;

import com.arnab.ecom_order.dto.OrderDto;
import com.arnab.ecom_order.entity.Order;

@Mapper(componentModel = "spring", uses = ProductMapStructMapper.class)
public interface OrderMapStructMapper extends GenericMapStructMapper<OrderDto, Order> {

}
