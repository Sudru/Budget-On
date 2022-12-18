package com.sudru.BudgetOn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    @NotEmpty(message = "First name cannot be blank.")
    private String name;

    @Email(message = "Provide valid email.")
    private String username;
    @Length(min = 8,message = "Password should contains at least 8 characters.")
    private String password;
    private String confirmPassword;



}
