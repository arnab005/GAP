package com.arnab.bankingApp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table("customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
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
}
