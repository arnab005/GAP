package com.arnab.ecom_dashboard.dto;

import java.util.Date;
import java.util.List;

public class OrderDto {

	private String order_Id;
	private List<ProductDto> productDtosList;
	private String customerId;
	private Date orderDate;
	
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
}
