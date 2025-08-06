package com.arnab.ecom_cart.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.arnab.ecom_cart.dto.CartDto;
import com.arnab.ecom_cart.dto.ProductDto;
import com.arnab.ecom_cart.entity.Cart;
import com.arnab.ecom_cart.entity.Product;

public class CartUtilsConverter {

	public CartDto toDto (Cart cart) {
		if(cart == null) return null;
		CartDto cartDto = new CartDto();
		cartDto.setCid(cart.getCid());
		List<ProductDto> products = cart.getProducts()
				.stream()
				.map(CartUtilsConverter::toDto)
				.collect(Collectors.toList());
		cartDto.setProductDtos(products);
		return cartDto;
	}
	
	public static ProductDto toDto(Product product) {
		if(product == null) return null;
		ProductDto productDto = new ProductDto();
		productDto.setSkuId(product.getSkuId());
		productDto.setSkuName(product.getSkuName());
		productDto.setSkuPrice(product.getSkuPrice());
		productDto.setSkuDetails(product.getSkuDetails());
		return productDto;
	}
	
	public static Cart toEntity(CartDto cartDto) {
		Cart cart = new Cart();
		cart.setCid(cartDto.getCid());
		List<Product> products = cartDto.getProductDtos()
				.stream()
				.map(CartUtilsConverter::toEntity)
				.collect(Collectors.toList());
		cart.setProducts(products);
		return cart;
	}
	
	public static Product toEntity(ProductDto productDto) {
		Product product = new Product();
		product.setSkuId(productDto.getSkuId());
		product.setSkuName(productDto.getSkuName());
		product.setSkuDetails(product.getSkuDetails());
		product.setSkuPrice(productDto.getSkuPrice());
		product.setSkuType(product.getSkuType());
		return product;
	}
}
