package com.arnab.ecom_cart.utils;

import org.mapstruct.Mapper;

import com.arnab.ecom_cart.dto.CartDto;
import com.arnab.ecom_cart.dto.ProductDto;
import com.arnab.ecom_cart.entity.Cart;
import com.arnab.ecom_cart.entity.Product;

@Mapper(componentModel = "spring")
public interface CartUtilsMapper {
	
	CartDto toDto(Cart cart);
	
	Cart toEntity(CartDto cartDto);
	
	ProductDto toDto(Product product);
	
	Product toEntity(ProductDto productDto);

}
