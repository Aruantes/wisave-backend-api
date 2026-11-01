package com.finance.finance_api.dto;

import com.finance.finance_api.model.Transaction;
import com.finance.finance_api.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponseDTO (
    Long id,
    String description,
    BigDecimal amount,
    LocalDateTime dateTime,
    TransactionType type,
    
    String userName,
    String categoryName
) {
    public TransactionResponseDTO(Transaction transaction) {
        this(
            transaction.getId(),
            transaction.getDescription(),
            transaction.getAmount(),
            transaction.getDateTime(),
            transaction.getType(),
            transaction.getUser().getName(),
            transaction.getCategory().getName()
        );
    }
}
