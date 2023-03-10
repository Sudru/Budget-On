package com.sudru.BudgetOn;

import com.sudru.BudgetOn.repository.UserRepository;
import com.sudru.BudgetOn.util.UserUtil;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BudgetOnApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetOnApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	public UserUtil queryUtils(UserRepository userRepository){
		return new UserUtil(userRepository);
	}
}
