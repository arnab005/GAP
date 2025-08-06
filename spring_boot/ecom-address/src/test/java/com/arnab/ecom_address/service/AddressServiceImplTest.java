package com.arnab.ecom_address.service;

import static com.arnab.ecom_address.utils.AddressTestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.arnab.ecom_address.dto.AddressDto;
import com.arnab.ecom_address.entity.Address;
import com.arnab.ecom_address.exception.AddressNotFoundException;
import com.arnab.ecom_address.repository.AddressRepository;
import com.arnab.ecom_address.service.impl.AddressServiceImpl;
import com.arnab.ecom_address.utils.AddressBindingTestUtils;
import com.arnab.ecom_address.utils.AddressUtils;

@ExtendWith(MockitoExtension.class)
public class AddressServiceImplTest {

	@Mock // Creates a mock instance of AddressRepository
	private AddressRepository addressRepository;
	
	@Mock
	private ModelMapper modelMapper;
	
	@Mock
	private AddressUtils addressUtils;
	
	@InjectMocks // Injects the mocked AddressService into Address Controller
	private AddressServiceImpl addressServiceImpl;
	
	private AddressDto testAddressDto;
	private Address testAddress;
	
	
	
	@BeforeEach
	void setUp() {
		testAddressDto = new AddressDto("c123", "Shapoorji", "Newtown", 700135L, "WB");
		testAddress = new Address("c123", "Shapoorji", "Newtown", 700135L, "WB");
	}
	
	@Test
	@Order(1)
	@DisplayName("Should Get Address By Id Successfully")
	void shouldGetAddressByIdOneSuccessfully() throws Exception {
		
		// Arrange
		when(addressUtils.entityToDto(testAddress)).thenReturn(testAddressDto);
		when(addressRepository.findById("c123")).thenReturn(Optional.ofNullable(testAddress));
		
		//	Act
		AddressDto responseAddressDto = addressServiceImpl.getById("c123").get();
		
		//	Assert
		assertEquals(testAddressDto.getCid(), responseAddressDto.getCid());
		assertEquals(testAddressDto.getState(), responseAddressDto.getState());
	}
	
	@Test
	@Order(2)
	@DisplayName("Should Get Address By Id Not Found")
	void shouldGetAddressByIdNotFound() throws Exception {
		String errorMessage = String.format("No such Address present with '%s' ", "c123");
		when(addressRepository.findById("c123")).thenThrow(new AddressNotFoundException(errorMessage));
		
		Exception exception = assertThrows(RuntimeException.class, () -> {
			addressServiceImpl.getById(testAddressDto.getCid());
		});
		
		assertEquals(errorMessage, exception.getMessage());
	}
	
	
	@Test
	@Order(3)
	@DisplayName("Should Get All Addresses")
	void shouldGetAllAddressWithArrayOfTwoItemsSuccessfully() {
		
		List<AddressDto> responseList = Arrays.asList(
				createAddressDto("c123", "Shapoorji", "Newtown", 700135L, "WB"),
				createAddressDto("c124", "Sukhobrishti", "Newtown", 700156L, "WB"));
		
		List<Optional<AddressDto>> stubList = responseList
		.stream()
		.map(Optional::of)
		.collect(Collectors.toList());
		
		List<Address> responseAddresses = responseList.stream()
				.map(add -> new Address(add.getCid(), add.getStreet1(), add.getStreet2(), add.getPinCode(), add.getState()))
				.toList();
		
		when(addressUtils.entityToDto(responseAddresses.get(0))).thenReturn(responseList.get(0));
		when(addressUtils.entityToDto(responseAddresses.get(1))).thenReturn(responseList.get(1));
		
		when(addressRepository.findAll()).thenReturn(responseAddresses);
		
		List<Optional<AddressDto>> addressResponseList = addressServiceImpl.getAll();
		
		assertEquals(stubList, addressResponseList);
	}

	@Test
	@Order(4)
	@DisplayName("Should Get Empty Address")
	void shouldGetEmptyAddressWithArraySuccessfully() {
		
		List<Address> stubResponseList = Arrays.asList();
		when(addressRepository.findAll()).thenReturn(stubResponseList);
		
		List<Optional<AddressDto>> addressResponseList = addressServiceImpl.getAll();
		
		assertEquals(stubResponseList, addressResponseList);
	}
	
	@Test
	@Order(5)
	@DisplayName("Should Register Address successfully")
	void shouldRegisterAddressSuccessfully() {
		
		when(addressUtils.dtoToentity(testAddressDto)).thenReturn(testAddress);
		when(addressUtils.entityToDto(testAddress)).thenReturn(testAddressDto);
		
		when(addressRepository.save(addressUtils.dtoToentity(testAddressDto))).thenReturn(testAddress);
		
		AddressDto addressResponseDto = addressServiceImpl.save(testAddressDto);
		
		assertEquals(testAddressDto, addressResponseDto);
	}
	
	@Test
	@Order(6)
	@DisplayName("Should Register Address UnSuccessfull with empty request")
	void shouldRegisterAddressUnSuccessfullyWithEmptyRequest() {
		
		String errorMessage = String.format("Empty Request");
		when(addressRepository.save(testAddress)).thenThrow(new AddressNotFoundException("Empty Request"));
		
		Exception exception = assertThrows(AddressNotFoundException.class, () -> addressRepository.save(testAddress));
		
		assertEquals(errorMessage, exception.getMessage());
	}

	@Test
	@Order(7)
	@DisplayName("Should Register Address UnSuccessfull with Invalid Request request")
	void shouldRegisterAddressUnSuccessfullyWithInvalidRequest() {
		String errorMessage = String.format("Invalid Request");
		when(addressRepository.save(testAddress)).thenThrow(new AddressNotFoundException("Invalid Request"));
		
		Exception exception = assertThrows(AddressNotFoundException.class, () -> addressRepository.save(testAddress));
		
		assertEquals(errorMessage, exception.getMessage());
	}
}
