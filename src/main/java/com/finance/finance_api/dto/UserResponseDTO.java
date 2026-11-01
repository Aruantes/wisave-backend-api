package com.finance.finance_api.dto;

import com.finance.finance_api.model.User;

//dto de saida, para não expor a senha do usuário
public record UserResponseDTO (
    
    long id,
    String name,
    String email

){
    public UserResponseDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
