package com.arnab.ecom_cart.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arnab.ecom_cart.dto.CartDto;
import com.arnab.ecom_cart.dto.ProductDto;
import com.arnab.ecom_cart.entity.Cart;
import com.arnab.ecom_cart.entity.Product;

@Component
public class CartUtils {

	@Autowired
	private ModelMapper modelMapper;

	public CartDto entityToDto(Cart cart) {
		List<ProductDto> productDtos = listEntityToDtoProductDtos(cart.getProducts());
		CartDto cartDto = modelMapper.map(cart, CartDto.class);
		cartDto.setProductDtos(productDtos);
		return cartDto;
	}
	
	public Cart dtoToentity(CartDto cartDto) {
		List<Product> products = listDtoToEntityProducts(cartDto.getProductDtos());
		Cart cart = modelMapper.map(cartDto, Cart.class);
		cart.setProducts(products);
		return cart;
	}
	
	public List<CartDto> listEntityToDto(List<Cart> carts) {
		TypeToken<List<CartDto>> typeToken = new TypeToken<>() {};
		return modelMapper.map(carts, typeToken.getType());
	}
	
	public List<ProductDto> listEntityToDtoProductDtos(List<Product> products) {
		TypeToken<List<ProductDto>> typeToken = new TypeToken<>() {};
		return modelMapper.map(products, typeToken.getType());
	}
	
	public List<Cart> listDtoToEntity(List<CartDto> cartDtos) {
		TypeToken<List<Cart>> typeToken = new TypeToken<>() {};
		return modelMapper.map(cartDtos, typeToken.getType());
	}
	
	public List<Product> listDtoToEntityProducts(List<ProductDto> productDtos) {
		TypeToken<List<Product>> typeToken = new TypeToken<>() {};
		return modelMapper.map(productDtos, typeToken.getType());
	}
}
