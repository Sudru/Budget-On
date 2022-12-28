package com.sudru.BudgetOn.service;

import com.sudru.BudgetOn.dto.TransactionDto;
import com.sudru.BudgetOn.entity.Transaction;
import com.sudru.BudgetOn.entity.User;
import com.sudru.BudgetOn.repository.TransactionRepository;
import com.sudru.BudgetOn.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        transaction.setUser(userUtil.getCurrentLoggedInUser());
        transactionRepository.save(transaction);

    }

    public List<TransactionDto> getAllTransactions() {
        User user = userUtil.getCurrentLoggedInUser();
        return transactionRepository.getTransactionByUser(user).stream().map(a->modelMapper.map(a,TransactionDto.class)).collect(Collectors.toList());
    }
}
