package com.arnab.ecom_order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.arnab.ecom_order.dto.PaymentResponseDto;
import com.arnab.ecom_order.dto.PaymentRequestDto;

@FeignClient(name = "banking-app", url = "http://localhost:8090/BankingApp/transaction")
public interface PaymentService {
	
	@PostMapping("/transfer")
	PaymentResponseDto orderPayment(@RequestBody PaymentRequestDto paymentServiceDto);
	
}
