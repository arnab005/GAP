package com.arnab.ecom_login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arnab.ecom_login.entity.Login;

public interface LoginRepository extends JpaRepository<Login, String>{

	Login findByUserName(String userName);

}
