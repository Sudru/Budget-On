package com.sudru.BudgetOn.controller;

import com.sudru.BudgetOn.dto.ApiResponse;
import com.sudru.BudgetOn.dto.RegisterDto;
import com.sudru.BudgetOn.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody RegisterDto dto, Errors errors){
        if (errors.getAllErrors().size() > 0) {
            return new ResponseEntity<>(new ApiResponse(errors.getAllErrors().get(0).getDefaultMessage(), false), HttpStatus.BAD_REQUEST);
        }
        log.info(dto.toString());
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            return new ResponseEntity<>(new ApiResponse("Password do not match.", false), HttpStatus.BAD_REQUEST);
        }
        userService.registerUser(dto);
        return new ResponseEntity<>(new ApiResponse("User Created Successfully",true),HttpStatus.CREATED);

    }
}
