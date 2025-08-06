package com.arnab.ecom_dashboard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.arnab.ecom_dashboard.entity.Order;

@Repository
public interface DashboardRepository extends MongoRepository<Order, String> {

}
