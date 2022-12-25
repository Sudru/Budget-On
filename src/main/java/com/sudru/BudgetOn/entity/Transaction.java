package com.sudru.BudgetOn.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "transaction")
@Data
public class Transaction {
    @Id
    private int id;
    @CreationTimestamp
    private Date timestamp;

    private double amount;
    private boolean isPending;
    private TransactionType transactionType;
    private String note;
    private String senderOrReceiver;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
