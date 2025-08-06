package com.arnab.ecom_address.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.arnab.ecom_address.dto.ErrorResponseDto;
import com.arnab.ecom_address.exception.AddressNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleNotFound(AddressNotFoundException ex) {
		ErrorResponseDto errorResponseDto = new ErrorResponseDto("NOT_FOUND", ex.getMessage());
		return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponseDto> handleIllegalArgumentException(IllegalArgumentException ex) {
		ErrorResponseDto errorResponseDto = new ErrorResponseDto("BAD_REQUEST", ex.getMessage());
		return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
		Map<String, String> errorsMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> 
		errorsMap.put(error.getField(), error.getDefaultMessage())
		);
		return new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> handleGeneric(Exception ex) {
		ErrorResponseDto errorResponseDto = new ErrorResponseDto("INTERNAL_ERROR", "Something went wrong");
		return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
