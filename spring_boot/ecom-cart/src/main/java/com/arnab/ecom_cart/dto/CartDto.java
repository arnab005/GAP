package com.arnab.ecom_cart.dto;

import java.util.List;

public class CartDto {
	
	private String cid;
	private List<ProductDto> productDtos;
	
	public CartDto() {
		super();
	}
	
	public CartDto(String cid, List<ProductDto> productDtos) {
		super();
		this.cid = cid;
		this.productDtos = productDtos;
	}
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public List<ProductDto> getProductDtos() {
		return productDtos;
	}
	public void setProductDtos(List<ProductDto> productDtos) {
		this.productDtos = productDtos;
	}
}
