package com.arnab.bankingApp.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    public String customerId;
    public String accountNumber;
    public String customerName;
    public String sex;
    public Integer aadharNumber;
    public Integer panNumber;
    public Integer mobileNumber;
    public String customerAddress;
    public Date accountOpeningDate;
    public Date accountClosedDate;

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
