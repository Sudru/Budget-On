package com.sudru.BudgetOn.repository;

import com.sudru.BudgetOn.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    @Query(value = "select * from transaction where is_pending=?2 and user_id=?1",nativeQuery = true)
    List<Transaction> getTransactionByUserId(int id, boolean pending);

    @Modifying
    @Transactional
    @Query(value = "insert into transaction(transaction_type,sender_or_receiver,amount,note,is_pending,user_id,timestamp) values (?1,?2,?3,?4,?5,?6,?7)",nativeQuery = true)
    void addTransaction(int type, String senderOrReceiver, double amount, String note, boolean isPending, int userId, Date timestamp);

    @Modifying
    @Transactional
    @Query(value = "delete from transaction where id=?1",nativeQuery = true)
    void deleteTransaction(int id);

    @Modifying
    @Transactional
    @Query(value = "update transaction set transaction_type=?1,sender_or_receiver=?2,amount=?3,note=?4,is_pending=?5,user_id=?6,timestamp=?7 where id=?8",nativeQuery = true)
    void editTransaction(int type, String senderOrReceiver, double amount, String note, boolean isPending, int userId, Date timestamp,int id);

    @Query(value = "select sum(case when is_pending=false and transaction_type=0 then amount else 0 end) as income,sum(case when is_pending=false and transaction_type=1 then amount else 0 end) as expenditure,sum(case when is_pending=true and transaction_type=0 then amount else 0 end) as income_pending,sum(case when is_pending=true and transaction_type=1 then amount else 0 end) as expenditure_pending from transaction where user_id=?1",nativeQuery = true)
    String getTransactionSummary(int id);
}
