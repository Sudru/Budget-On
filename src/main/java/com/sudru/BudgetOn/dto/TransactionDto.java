package com.sudru.BudgetOn.dto;

import com.sudru.BudgetOn.entity.TransactionType;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class TransactionDto {
    private int id;
    private double amount;
    private boolean isPending;
    @NotBlank(message = "Specify Sender or Receiver")
    private String senderOrReceiver;
    private TransactionType transactionType;
    private Date timestamp;
    private String note;
}
