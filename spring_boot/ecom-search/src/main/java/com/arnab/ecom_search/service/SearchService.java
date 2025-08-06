package com.arnab.ecom_search.service;

import java.util.List;

import com.arnab.ecom_search.dto.ProductDto;

public interface SearchService {

	public ProductDto getById(String cid);

	public List<ProductDto> getAll();
	
}
