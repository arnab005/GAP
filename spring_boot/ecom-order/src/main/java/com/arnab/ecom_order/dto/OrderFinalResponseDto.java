package com.arnab.ecom_order.dto;

public class OrderFinalResponseDto {

	private OrderDto orderDto;
	private PaymentResponseDto paymentResponseDto;
	
	public OrderDto getOrderDto() {
		return orderDto;
	}
	public void setOrderDto(OrderDto orderDto) {
		this.orderDto = orderDto;
	}
	public PaymentResponseDto getPaymentResponseDto() {
		return paymentResponseDto;
	}
	public void setPaymentResponseDto(PaymentResponseDto paymentResponseDto) {
		this.paymentResponseDto = paymentResponseDto;
	}
}
