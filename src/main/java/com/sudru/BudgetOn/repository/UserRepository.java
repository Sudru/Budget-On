package com.sudru.BudgetOn.repository;

import com.sudru.BudgetOn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select * from users where username=?1",nativeQuery = true)
    Optional<User> getByUsername(String s);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users(name,username,password) values (?1,?2,?3)",nativeQuery = true)
    void saveNewUser(String name,String username,String password);
}
