package com.finance.finance_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO (
    //não pode estar em banco
    @NotBlank(message = "Name is required.")
    @Size(max = 100, message = "Name must be at most 100 characters.")
    String name,

    //email segue padrão "exemplo@dominio.com"
    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email format.")
    String email,

    //senha não pode ser nula, em branco e deve ter no mínimo 6 caracteres
    @NotBlank(message = "Password is required.")
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    String password

){}
