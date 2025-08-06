package com.arnab.ecom_address.utils;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arnab.ecom_address.dto.AddressDto;
import com.arnab.ecom_address.entity.Address;

@Component
public class AddressUtils {
	
	
	private final ModelMapper modelMapper;
	
	@Autowired
	public AddressUtils(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public AddressDto entityToDto(Address address) {
		return modelMapper.map(address, AddressDto.class);
	}
	
	public Address dtoToentity(AddressDto addressDto) {
		return modelMapper.map(addressDto, Address.class);
	}
	
	public List<AddressDto> listEntityToDto(List<Address> address) {
		TypeToken<List<AddressDto>> typeToken = new TypeToken<>() {};
		return modelMapper.map(address, typeToken.getType());
	}
	
	public List<Address> listDtoToEntity(List<AddressDto> addressDtos) {
		TypeToken<List<Address>> typeToken = new TypeToken<>() {};
		return modelMapper.map(addressDtos, typeToken.getType());
	}
	
}
