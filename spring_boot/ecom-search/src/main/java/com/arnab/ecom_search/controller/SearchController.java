package com.arnab.ecom_search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.ecom_search.dto.ProductDto;
import com.arnab.ecom_search.service.SearchService;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@GetMapping("/get")
	public ProductDto get(@RequestParam String cid) {
		return searchService.getById(cid);
	}
	
	@GetMapping("/getAll")
	public List<ProductDto> getAll() {
		return searchService.getAll();
	}
}
