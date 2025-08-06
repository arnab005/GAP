package com.arnab.ecom_address.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static com.arnab.ecom_address.utils.AddressTestUtils.createAddressDto;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.arnab.ecom_address.dto.AddressDto;
import com.arnab.ecom_address.exception.AddressNotFoundException;
import com.arnab.ecom_address.service.AddressService;

@ExtendWith(MockitoExtension.class) // Integrates Mockito with Junit 5
public class AddressControllerTests {
	
	@InjectMocks // Injects the mocked AddressService into Address Controller
	private AddressController addressController;
	
	@Mock
	private AddressService addressService;
	
	private AddressDto testAddress;
	
	@BeforeEach
	void setUp() {
		testAddress = new AddressDto("c123", "Shapoorji", "Newtown", 700135L, "WB");
	}
	
	@Test
	@Order(1)
	@DisplayName("Should Get Address By Id Successfully")
	void shouldGetAddressByIdOneSuccessfully() throws Exception {
		// Arrange
		when(addressService.getById("c123")).thenReturn(Optional.of(testAddress));
		
		//Act
		ResponseEntity<?> response = addressController.get("c123");
		
		//Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(testAddress, response.getBody());
		
	}
	
	@Test
	@Order(2)
	@DisplayName("Should Get Address By Id Not Found")
	void shouldGetAddressByIdNotFound() throws Exception {
		String errorMessage = String.format("No such Address present with '%s' ", "c111");
		when(addressService.getById("c111")).thenThrow(new AddressNotFoundException(errorMessage));
		
		Exception exception = assertThrows(RuntimeException.class, () -> {
			addressController.get("c111");
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
		
		when(addressService.getAll()).thenReturn(stubList);
		
		ResponseEntity<?> addressResponse = addressController.getAll();
		
		assertEquals(HttpStatus.OK, addressResponse.getStatusCode());
		assertEquals(responseList, addressResponse.getBody());
	}
	
	@Test
	@Order(4)
	@DisplayName("Should Get Empty Address")
	void shouldGetEmptyAddressWithArraySuccessfully() {
		
		List<Optional<AddressDto>> stubList = Arrays.asList(new AddressDto())
				.stream()
				.map(Optional::of)
				.toList();
		
		
		when(addressService.getAll()).thenReturn(stubList);
		
		ResponseEntity<?> addressResponse = addressController.getAll();
		
		assertEquals(HttpStatus.OK, addressResponse.getStatusCode());
		assertEquals(stubList.stream().map(Optional::get).toList(), addressResponse.getBody());
	}
	
	@Test
	@Order(5)
	@DisplayName("Should Register Address successfully")
	void shouldRegisterAddressSuccessfully() {
		
		when(addressService.save(testAddress)).thenReturn(testAddress);
		
		ResponseEntity<?> addressResponse = addressController.save(testAddress);
		
		assertEquals(HttpStatus.CREATED, addressResponse.getStatusCode());
		assertEquals(testAddress, addressResponse.getBody());
	}
	
	@Test
	@Order(6)
	@DisplayName("Should Register Address UnSuccessfull with empty request")
	void shouldRegisterAddressUnSuccessfullyWithEmptyRequest() {
		testAddress = new AddressDto();
		String errorMessage = String.format("Empty Request");
		when(addressService.save(testAddress)).thenThrow(new AddressNotFoundException("Empty Request"));
		
		Exception exception = assertThrows(AddressNotFoundException.class, () -> addressController.save(testAddress));
		
		assertEquals(errorMessage, exception.getMessage());
	}
	
	@Test
	@Order(7)
	@DisplayName("Should Register Address UnSuccessfull with Invalid Request request")
	void shouldRegisterAddressUnSuccessfullyWithInvalidRequest() {
		testAddress = createAddressDto("c123", null, null, null, "WB");
		String errorMessage = String.format("Invalid Request");
		
		when(addressService.save(testAddress)).thenThrow(new AddressNotFoundException("Invalid Request"));
		
		Exception exception = assertThrows(AddressNotFoundException.class, () -> addressController.save(testAddress));
		
		assertEquals(errorMessage, exception.getMessage());
	}
	
	
	
}
