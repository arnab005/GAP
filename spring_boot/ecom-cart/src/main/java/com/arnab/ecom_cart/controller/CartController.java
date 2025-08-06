package com.arnab.ecom_cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.ecom_cart.dto.CartDto;
import com.arnab.ecom_cart.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/save")
	public CartDto save(@RequestBody CartDto cartDto) {
		return cartService.save(cartDto);
	}
	
	@GetMapping("/get")
	public CartDto get(@RequestParam String cid) {
		return cartService.getById(cid);
	}
	
	@GetMapping("/getAll")
	public List<CartDto> getAll() {
		return cartService.getAll();
	}
}
