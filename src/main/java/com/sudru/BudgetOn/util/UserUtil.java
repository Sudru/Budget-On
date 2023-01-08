package com.sudru.BudgetOn.util;

import com.sudru.BudgetOn.entity.User;
import com.sudru.BudgetOn.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

@RequiredArgsConstructor
public class UserUtil {
    private final UserRepository userRepository;
    public User getCurrentLoggedInUser(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.getByUsername(email).orElseThrow();

    }
}
