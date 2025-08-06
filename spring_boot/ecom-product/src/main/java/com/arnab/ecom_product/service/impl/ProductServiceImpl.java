package com.arnab.ecom_product.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.ecom_product.dto.ProductDto;
import com.arnab.ecom_product.entity.Product;
import com.arnab.ecom_product.repository.ProductRepository;
import com.arnab.ecom_product.service.ProductService;
import com.arnab.ecom_product.utils.ProductUtils;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductUtils productUtils;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ProductDto save(ProductDto productDto) {
		return productUtils.entityToDto(productRepository.save(productUtils.dtoToentity(productDto)));
	}

	@Override
	public ProductDto getById(String cid) {
		Optional<Product> optional = productRepository.findById(cid);
		return  optional.isPresent()? productUtils.entityToDto(optional.get()) : productUtils.entityToDto(optional.orElseThrow());
	}

	@Override
	public List<ProductDto> getAll() {
		return productUtils.listEntityToDto(productRepository.findAll());
	}

}
