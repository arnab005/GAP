package com.arnab.ecom_address.service;

import java.util.List;
import java.util.Optional;

import com.arnab.ecom_address.dto.AddressDto;

public interface AddressService {
	
	public AddressDto save(AddressDto addressDto);
	
	public Optional<AddressDto> getById(String cid);

	public List<Optional<AddressDto>> getAll();

}
