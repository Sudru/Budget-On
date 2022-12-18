package com.sudru.BudgetOn.controller;

import com.sudru.BudgetOn.dto.ApiResponse;
import com.sudru.BudgetOn.dto.RegisterDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody RegisterDto dto, Errors errors){
        if (errors.getAllErrors().size() > 0) {
            return new ResponseEntity<>(new ApiResponse(errors.getAllErrors().get(0).getDefaultMessage(), false), HttpStatus.BAD_REQUEST);
        }
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            return new ResponseEntity<>(new ApiResponse("Password do not match.", false), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ApiResponse("User Created Successfully",true),HttpStatus.CREATED);

    }
}
