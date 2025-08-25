package com.FirstProject.Store.dtos;


import com.FirstProject.Store.validation.Lowercase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "Name is Required")
    @Size(max=255,message = "keep name in given range")
    private String name;

    @NotBlank(message = "Please enter email")
    @Email(message = "Email must be valid")
    @Lowercase(message="email must be in LowerCase")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(message = "Password must be minimum 6chars and maximum chars", min=6,max = 25)
    private String password;
}

