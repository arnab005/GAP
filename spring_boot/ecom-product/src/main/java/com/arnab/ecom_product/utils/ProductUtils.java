package com.arnab.ecom_product.utils;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arnab.ecom_product.dto.ProductDto;
import com.arnab.ecom_product.entity.Product;


@Component
public class ProductUtils {
	
	@Autowired
	private ModelMapper modelMapper;

	public ProductDto entityToDto(Product product) {
		return modelMapper.map(product, ProductDto.class);
	}
	
	public Product dtoToentity(ProductDto productDto) {
		return modelMapper.map(productDto, Product.class);
	}
	
	public List<ProductDto> listEntityToDto(List<Product> products) {
		TypeToken<List<ProductDto>> typeToken = new TypeToken<>() {};
		return modelMapper.map(products, typeToken.getType());
	}
	
	public List<Product> listDtoToEntity(List<ProductDto> productDtos) {
		TypeToken<List<Product>> typeToken = new TypeToken<>() {};
		return modelMapper.map(productDtos, typeToken.getType());
	}
	
}
