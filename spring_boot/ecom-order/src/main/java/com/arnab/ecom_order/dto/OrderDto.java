package com.arnab.ecom_order.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
public class OrderDto {

	private String customerId;
	@JsonProperty(access = Access.READ_ONLY)
	private String order_Id;
	private List<ProductDto> productDtosList;
	@JsonProperty(access = Access.READ_ONLY)
	private Date orderDate;
	@JsonProperty(access = Access.WRITE_ONLY)
	private PaymentRequestDto paymentRequestDto;
	
	public OrderDto() {
		super();
	}
	public OrderDto(String customerId, String order_Id, List<ProductDto> productDtosList, Date orderDate,
			PaymentRequestDto paymentRequestDto) {
		super();
		this.customerId = customerId;
		this.order_Id = order_Id;
		this.productDtosList = productDtosList;
		this.orderDate = orderDate;
		this.paymentRequestDto = paymentRequestDto;
	}
	public String getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(String order_Id) {
		this.order_Id = order_Id;
	}
	public List<ProductDto> getProductDtosList() {
		return productDtosList;
	}
	public void setProductDtosList(List<ProductDto> productDtosList) {
		this.productDtosList = productDtosList;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public PaymentRequestDto getPaymentRequestDto() {
		return paymentRequestDto;
	}
	public void setPaymentRequestDto(PaymentRequestDto paymentRequestDto) {
		this.paymentRequestDto = paymentRequestDto;
	}
}
