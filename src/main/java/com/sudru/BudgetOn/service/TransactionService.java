package com.sudru.BudgetOn.service;

import com.sudru.BudgetOn.dto.TransactionDto;
import com.sudru.BudgetOn.entity.Transaction;
import com.sudru.BudgetOn.entity.User;
import com.sudru.BudgetOn.repository.TransactionRepository;
import com.sudru.BudgetOn.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;
    private final UserUtil userUtil;


    public void addTransaction(TransactionDto dto){
        Transaction transaction = modelMapper.map(dto, Transaction.class);
        int userId=userUtil.getCurrentLoggedInUser().getId();
        transactionRepository.addTransaction(transaction.getTransactionType().ordinal(),transaction.getSenderOrReceiver(),transaction.getAmount(),transaction.getNote(),transaction.isPending(),userId, Date.from(Instant.now()));

    }

    public List<TransactionDto> getAllTransactions(boolean pending) {
        User user = userUtil.getCurrentLoggedInUser();
        return transactionRepository.getTransactionByUserId(user.getId(),pending).stream().map(a->modelMapper.map(a,TransactionDto.class)).collect(Collectors.toList());
    }

    public void updateTransaction(TransactionDto dto) {
        int authenticatedUserId = userUtil.getCurrentLoggedInUser().getId();
        Transaction transaction = transactionRepository.findById(dto.getId()).orElseThrow(()-> new RuntimeException("Invalid transaction Id"));
        if(transaction.getUser().getId()!=authenticatedUserId){
            throw new RuntimeException("Unauthorized");
        }
        dto.setTimestamp(transaction.getTimestamp());
        modelMapper.map(dto,transaction);
        transactionRepository.editTransaction(transaction.getTransactionType().ordinal(),transaction.getSenderOrReceiver(),transaction.getAmount(),transaction.getNote(),transaction.isPending(),authenticatedUserId, transaction.getTimestamp(),transaction.getId());

    }

    public void deleteTransaction(int id) {
        int authenticatedUserId = userUtil.getCurrentLoggedInUser().getId();
        Transaction t = transactionRepository.findById(id).orElseThrow(()-> new RuntimeException("Invalid Id"));
        if(t.getUser().getId()!=authenticatedUserId){
            throw new RuntimeException("Unauthorized");
        }
        transactionRepository.deleteTransaction(id);
    }

    public String getSummary() {
        int userId = userUtil.getCurrentLoggedInUser().getId();
        return transactionRepository.getTransactionSummary(userId);
    }
}
