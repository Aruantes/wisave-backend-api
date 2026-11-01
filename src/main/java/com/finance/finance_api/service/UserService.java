package com.finance.finance_api.service;

import com.finance.finance_api.dto.UserRequestDTO;
import com.finance.finance_api.dto.UserResponseDTO;
import com.finance.finance_api.model.User;
import com.finance.finance_api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponseDTO register(UserRequestDTO dto) {
        

    //impede a duplicidade de email no banco de dados
        if (userRepository.existsByEmail(dto.email())) {
            throw new RuntimeException("Email already exists: " + dto.email());
        }

        //converte o DTO para a entidade User jpa
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());

        user.setPasswordHash(dto.password());

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(savedUser);
    }

    @Transactional 
    public UserResponseDTO findById(Long id) {
       User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        return new UserResponseDTO(user);
    }

    @Transactional (readOnly = true)
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDTO::new)
                .toList();
    }
}
