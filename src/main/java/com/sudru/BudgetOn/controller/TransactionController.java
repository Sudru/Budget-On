package com.sudru.BudgetOn.controller;

import com.sudru.BudgetOn.dto.ApiResponse;
import com.sudru.BudgetOn.dto.TransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    @PostMapping("/new")
    public ResponseEntity<ApiResponse> addNewTransaction(@Valid @RequestBody TransactionDto dto, Errors errors){
        if (errors.getAllErrors().size() > 0) {
            return new ResponseEntity<>(new ApiResponse(errors.getAllErrors().get(0).getDefaultMessage(), false), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new ApiResponse("Transaction Added",true),HttpStatus.OK);
    }

}
