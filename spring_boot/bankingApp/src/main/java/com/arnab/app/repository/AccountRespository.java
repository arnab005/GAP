package com.arnab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arnab.app.model.Account;

public interface AccountRespository extends JpaRepository<Account, Long> {

}
