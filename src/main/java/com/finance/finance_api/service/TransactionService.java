package com.finance.finance_api.service;

import com.finance.finance_api.dto.TransactionRequestDTO;
import com.finance.finance_api.dto.TransactionResponseDTO;
import com.finance.finance_api.model.Category;
import com.finance.finance_api.model.Transaction;
import com.finance.finance_api.model.User;
import com.finance.finance_api.repository.CategoryRepository;
import com.finance.finance_api.repository.TransactionRepository;
import com.finance.finance_api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service 
public class TransactionService {
    
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public TransactionResponseDTO create(TransactionRequestDTO dto) {
        //regra de negócio 1: verifica se o usuário existe no banco de dados
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.userId()));
        
        //regra de negócio 2: verifica se a categoria existe no banco de dados
        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + dto.categoryId()));

        //mapeia o DTO para a entidade Transaction e salva no banco de dados
        Transaction transaction = new Transaction();
        transaction.setDescription(dto.description());
        transaction.setAmount(dto.amount());
        transaction.setType(dto.type());
        transaction.setDateTime(LocalDateTime.now());
        transaction.setUser(user);
        transaction.setCategory(category);

        //persiste a transação no banco de dados e retorna o DTO de resposta
        Transaction savedTransaction = transactionRepository.save(transaction);
        
        //retorna o DTO de resposta com os dados da transação criada
        return new TransactionResponseDTO(savedTransaction);
    }

    @Transactional(readOnly = true)
    public List<TransactionResponseDTO> findById(Long Id) {
        Transaction transaction = transactionRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + Id));

                return new TransactionResponseDTO(transaction);
    }

    @Transactional(readOnly = true)
    public List<TransactionResponseDTO> findByUserId(Long userId) {
        return transactionRepository.findByUserId(userId)
                .stream()
                .map(TransactionResponseDTO::new)
                .toList();
    }

    @Transactional
    public void delete(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new RuntimeException("Transaction not found with id: " + id);
        }
        transactionRepository.deleteById(id);
    }
}
