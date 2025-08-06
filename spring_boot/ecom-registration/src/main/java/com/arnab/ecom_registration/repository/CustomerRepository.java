package com.arnab.ecom_registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arnab.ecom_registration.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
