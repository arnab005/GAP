package com.arnab.ecom_search.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.arnab.ecom_search.dto.ProductDto;
import com.arnab.ecom_search.entity.Product;
import com.arnab.ecom_search.repository.SearchRepository;
import com.arnab.ecom_search.service.SearchService;
import com.arnab.ecom_search.utils.SearchUtils;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchUtils searchUtils;
	
	@Autowired
	private SearchRepository searchRepository; 
	
	@Override
	public ProductDto getById(String cid) {
		Optional<Product> optional = searchRepository.findById(cid);
		return  optional.isPresent()? searchUtils.entityToDto(optional.get()) : searchUtils.entityToDto(optional.orElseThrow());
	}

	@Override
	public List<ProductDto> getAll() {
		return searchUtils.listEntityToDto(searchRepository.findAll());
	}

}
