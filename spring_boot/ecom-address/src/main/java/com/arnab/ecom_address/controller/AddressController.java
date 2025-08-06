package com.arnab.ecom_address.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.ecom_address.dto.AddressDto;
import com.arnab.ecom_address.service.AddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/save")
	public ResponseEntity<AddressDto> save(@Valid @RequestBody AddressDto addressDto) {
		return new ResponseEntity<>(addressService.save(addressDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<AddressDto> get(@RequestParam String cid) {
		Optional<AddressDto> optionalAddress = addressService.getById(cid);
		AddressDto addressDto = optionalAddress.get();
		return ResponseEntity.ok(addressDto);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<AddressDto>> getAll() {
		return ResponseEntity.ok(addressService.getAll()
				.stream()
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList()));
	}
	

}
