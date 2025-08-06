package com.arnab.bankingApp.Repository;

import com.arnab.bankingApp.Entity.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {
}
