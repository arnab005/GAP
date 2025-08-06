package com.arnab.ecom_address.utils;

import com.arnab.ecom_address.dto.AddressDto;
import com.arnab.ecom_address.entity.Address;

public class AddressTestUtils {

	public static AddressDto createAddressDto (String cid, String street1, String street2, Long pinCode, String state) {
		return AddressDto.builder()
				.cid(cid)
				.street1(street1)
				.street2(street2)
				.pinCode(pinCode)
				.state(state)
				.build();
	}
	
	public static Address createAddress (String cid, String street1, String street2, Long pinCode, String state) {
		return Address.builder()
				.cid(cid)
				.street1(street1)
				.street2(street2)
				.pinCode(pinCode)
				.state(state)
				.build();
	}
	
}
