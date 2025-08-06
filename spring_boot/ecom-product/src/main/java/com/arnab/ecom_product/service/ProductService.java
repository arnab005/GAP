package com.arnab.ecom_product.service;

import java.util.List;

import com.arnab.ecom_product.dto.ProductDto;

public interface ProductService {

	public ProductDto save(ProductDto productDto);
	
	public ProductDto getById(String cid);

	public List<ProductDto> getAll();
}
