package com.arnab.bankingApp.Repository;

import com.arnab.bankingApp.Entity.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account, String> {
}
