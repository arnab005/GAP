package com.arnab.ecom_product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.ecom_product.dto.ProductDto;
import com.arnab.ecom_product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ProductDto save(@RequestBody ProductDto productDto) {
		return productService.save(productDto);
	}
	
	@GetMapping("/get")
	public ProductDto get(@RequestParam String cid) {
		return productService.getById(cid);
	}
	
	@GetMapping("/getAll")
	public List<ProductDto> getAll() {
		return productService.getAll();
	}
}
