package com.arnab.bankingApp.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    public String accountNumber;
    public Double accountBalance;
}
