package com.arnab.ecom_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arnab.ecom_cart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, String>{

}
