package com.arnab.ecom_order.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.arnab.ecom_order.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>{

}
