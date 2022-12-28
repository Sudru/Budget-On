package com.sudru.BudgetOn.controller;

import com.sudru.BudgetOn.dto.ApiResponse;
import com.sudru.BudgetOn.dto.TransactionDto;
import com.sudru.BudgetOn.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping()
    public ResponseEntity<ApiResponse> addNewTransaction(@Valid @RequestBody TransactionDto dto, Errors errors){
        if (errors.getAllErrors().size() > 0) {
            return new ResponseEntity<>(new ApiResponse(errors.getAllErrors().get(0).getDefaultMessage(), false), HttpStatus.BAD_REQUEST);
        }
        transactionService.addTransaction(dto);
        return new ResponseEntity<>(new ApiResponse("Transaction Added",true),HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<?> getAllTransactions(){
        return new ResponseEntity<>(transactionService.getAllTransactions(),HttpStatus.OK);
    }

    @PutMapping
    public ApiResponse updateTransaction(@Valid @RequestBody TransactionDto dto,Errors errors ){
        if (errors.getAllErrors().size() > 0) {
            return new ApiResponse(errors.getAllErrors().get(0).getDefaultMessage(), false);
        }
        transactionService.updateTransaction(dto);
        return new ApiResponse("updated",true);
    }
    @DeleteMapping("/{id}")
    public ApiResponse deleteTransaction(@PathVariable int id){
        transactionService.deleteTransaction(id);
        return new ApiResponse("Transaction Deleted Successfully.",true);
    }

}
