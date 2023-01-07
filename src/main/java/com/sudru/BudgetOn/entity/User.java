package com.sudru.BudgetOn.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
@Getter
@Setter
public class User {
    @Id
    private int id;
    private String name;
    private String username;
    private String password;

}
