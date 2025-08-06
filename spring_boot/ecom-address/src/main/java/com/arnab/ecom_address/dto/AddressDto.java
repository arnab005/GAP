package com.arnab.ecom_address.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {

	@NotBlank(message = "Customer Id cannot be null or empty or blank")
	private String cid;
	@NotEmpty(message = "This is a mandatory field, Please provide your address")
	private String street1;
	private String street2;
	@Min(value = 99999, message = "pinCode value must be in 6 digit")
	@Positive
	private Long pinCode;
	@NotBlank(message = "State cannot be null or empty or blank")
	private String state;
	
//	public AddressDto() {
//		super();
//	}
//	
	@Builder
	public AddressDto(String cid, String street1, String street2, Long pinCode, String state) {
		this.cid = cid;
		this.street1 = street1;
		this.street2 = street2;
		this.pinCode = pinCode;
		this.state = state;
	}
//	
//	public String getCid() {
//		return cid;
//	}
//	public void setCid(String cid) {
//		this.cid = cid;
//	}
//	public String getStreet1() {
//		return street1;
//	}
//	public void setStreet1(String street1) {
//		this.street1 = street1;
//	}
//	public String getStreet2() {
//		return street2;
//	}
//	public void setStreet2(String street2) {
//		this.street2 = street2;
//	}
//	public Long getPinCode() {
//		return pinCode;
//	}
//	public void setPinCode(Long pinCode) {
//		this.pinCode = pinCode;
//	}
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
}
