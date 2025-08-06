package com.arnab.bankingApp.Repository;

import com.arnab.bankingApp.Entity.TransactionHistory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHistoryRepository extends ReactiveCrudRepository<TransactionHistory, String> {
}
