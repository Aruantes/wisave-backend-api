package com.finance.finance_api.dto;

import com.finance.finance_api.model.TransactionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record TransactionRequestDTO (
    @NotNull(message = "Description is required.")
    @Size(max = 255, message = "Description must be at most 255 characters.")
    String description,

    @NotNull(message = "Amount is required.")
    @Positive(message = "Amount must be greater than zero.")
    BigDecimal amount,

    @NotNull(message = "Transaction type is required.")
    TransactionType type,

    @NotNull(message = "User ID is required.")
    Long userId,

    @NotNull(message = "Category ID is required.")
    Long categoryId
){}
