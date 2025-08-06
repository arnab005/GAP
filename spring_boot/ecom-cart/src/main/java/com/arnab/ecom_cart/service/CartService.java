package com.arnab.ecom_cart.service;

import java.util.List;

import com.arnab.ecom_cart.dto.CartDto;

public interface CartService {

	public CartDto save(CartDto productDto);
	
	public CartDto getById(String cid);

	public List<CartDto> getAll();
}
