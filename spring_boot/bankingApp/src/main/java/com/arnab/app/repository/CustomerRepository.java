package com.arnab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arnab.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
