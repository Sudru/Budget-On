package com.sudru.BudgetOn.service;


import com.sudru.BudgetOn.dto.RegisterDto;
import com.sudru.BudgetOn.entity.User;
import com.sudru.BudgetOn.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;
    public void registerUser(RegisterDto registerDto) {

    }

}