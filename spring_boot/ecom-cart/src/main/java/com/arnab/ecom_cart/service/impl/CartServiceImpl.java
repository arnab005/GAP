package com.arnab.ecom_cart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.ecom_cart.dto.CartDto;
import com.arnab.ecom_cart.dto.ProductDto;
import com.arnab.ecom_cart.entity.Cart;
import com.arnab.ecom_cart.entity.Product;
import com.arnab.ecom_cart.repository.CartRepository;
import com.arnab.ecom_cart.service.CartService;
import com.arnab.ecom_cart.utils.CartUtils;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartUtils cartUtils;
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public CartDto save(CartDto cartDto) {
		List<Product> products = cartUtils.listDtoToEntityProducts(cartDto.getProductDtos());
		Cart cart = cartUtils.dtoToentity(cartDto);
		cart.setProducts(products);
		cart = cartRepository.save(cart);
		List<ProductDto> productDtos = cartUtils.listEntityToDtoProductDtos(cart.getProducts());
		CartDto cartDtoResponse = cartUtils.entityToDto(cart);
		cartDtoResponse.setProductDtos(productDtos);
		return cartDtoResponse;
	}

	@Override
	public CartDto getById(String cid) {
		Optional<Cart> optional = cartRepository.findById(cid);
		return  optional.isPresent()? cartUtils.entityToDto(optional.get()) : cartUtils.entityToDto(optional.orElseThrow());
	}

	@Override
	public List<CartDto> getAll() {
		return cartUtils.listEntityToDto(cartRepository.findAll());
	}

}
