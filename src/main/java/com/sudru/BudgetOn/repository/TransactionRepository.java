package com.sudru.BudgetOn.repository;

import com.sudru.BudgetOn.entity.Transaction;
import com.sudru.BudgetOn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> getTransactionByUser(User user);
}
