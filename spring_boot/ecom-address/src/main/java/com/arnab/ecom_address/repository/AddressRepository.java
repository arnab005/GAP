package com.arnab.ecom_address.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arnab.ecom_address.entity.Address;

public interface AddressRepository extends MongoRepository<Address, String>{

}
