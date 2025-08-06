package com.arnab.ecom_address.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.ecom_address.dto.AddressDto;
import com.arnab.ecom_address.exception.AddressNotFoundException;
import com.arnab.ecom_address.repository.AddressRepository;
import com.arnab.ecom_address.service.AddressService;
import com.arnab.ecom_address.utils.AddressUtils;

@Service
public class AddressServiceImpl implements AddressService {
	
	private AddressUtils addressUtils;
	
	private final AddressRepository addressRepository;

	public AddressServiceImpl(AddressUtils addressUtils, AddressRepository addressRepository) {
		this.addressUtils = addressUtils;
		this.addressRepository = addressRepository;
	}
	
	@Override
	public AddressDto save(AddressDto addressDto) {
		return addressUtils.entityToDto(addressRepository.save(addressUtils.dtoToentity(addressDto)));
//		return (AddressDto) Stream.of(addressDto)
//				.map(addressUtils::dtoToentity)
//				.map(addressRepository::save)
//				.map(addressUtils::entityToDto)
//				.map(Optional::get);
	}

	@Override
	public Optional<AddressDto> getById(String customerId) {
		return  addressRepository.findById(customerId)
				.map(addressUtils::entityToDto)
				.map(Optional::of)
				.orElseThrow(() -> new AddressNotFoundException(String.format("No such Address present with customerId %s.", customerId)));
	}

	@Override
	public List<Optional<AddressDto>> getAll() {
		return addressRepository.findAll()
				.stream()
				.map(addressUtils::entityToDto)
				.map(Optional::of)
				.collect(Collectors.toList());
	}

}
