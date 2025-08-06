package com.arnab.ecom_dashboard.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	private String skuId;
	private String skuName;
	private String skuDetails;
	private Double skuPrice;
	private String skuType;
	
	public Product(String skuId, String skuName, String skuDetails, Double skuPrice, String skuType) {
		super();
		this.skuId = skuId;
		this.skuName = skuName;
		this.skuDetails = skuDetails;
		this.skuPrice = skuPrice;
		this.skuType = skuType;
	}
	
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public String getSkuDetails() {
		return skuDetails;
	}
	public void setSkuDetails(String skuDetails) {
		this.skuDetails = skuDetails;
	}
	public Double getSkuPrice() {
		return skuPrice;
	}
	public void setSkuPrice(Double skuPrice) {
		this.skuPrice = skuPrice;
	}
	public String getSkuType() {
		return skuType;
	}
	public void setSkuType(String skuType) {
		this.skuType = skuType;
	}
}
