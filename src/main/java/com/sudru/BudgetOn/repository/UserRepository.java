package com.sudru.BudgetOn.repository;

import com.sudru.BudgetOn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> getByUsername(String s);
}
