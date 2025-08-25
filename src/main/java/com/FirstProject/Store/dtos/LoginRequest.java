package com.FirstProject.Store.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequest {

    @NotBlank(message = "Email field Can't be empty")
    @Email
    public String email;

    @NotBlank
    public String password;
}
