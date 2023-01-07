package com.sudru.BudgetOn.service;


import com.sudru.BudgetOn.dto.RegisterDto;
import com.sudru.BudgetOn.entity.User;
import com.sudru.BudgetOn.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private  final UserRepository userRepository;
    public void registerUser(RegisterDto registerDto) {
        User user = userRepository.getByUsername(registerDto.getUsername()).orElse(null);
        if (user != null) {
            throw new RuntimeException("User already exists.");
        }
        user = new User();
        user = modelMapper.map(registerDto,User.class);
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        userRepository.saveNewUser(user.getName(),user.getUsername(),user.getPassword());
    }

}
