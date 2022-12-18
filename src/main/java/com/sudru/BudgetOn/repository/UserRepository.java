package com.sudru.BudgetOn.repository;

import com.sudru.BudgetOn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
