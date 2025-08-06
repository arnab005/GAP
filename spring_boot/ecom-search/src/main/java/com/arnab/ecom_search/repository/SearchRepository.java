package com.arnab.ecom_search.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arnab.ecom_search.entity.Product;

public interface SearchRepository extends MongoRepository<Product, String> {

}
