package com.arnab.springSecurity.repo;

import com.arnab.springSecurity.model.Employee;
import com.arnab.springSecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String userName);
}
