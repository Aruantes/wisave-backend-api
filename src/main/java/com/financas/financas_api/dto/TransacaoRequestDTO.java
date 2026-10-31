package com.financas.financas_api.dto;

import com.financas.financas_api.model.TipoTransacao;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record TransacaoRequestDTO (
    @NotNull(message = "A descrição é obrigatória.")
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres.")
    String descricao,    

    @NotNull(message = "O valor é obrigatório.")
    @Positive(message = "O valor deve ser maior que zero.")
    BigDecimal valor,

    @NotNull(message = "O tipo da transação é obrigatório.")
    TipoTransacao tipo,

    @NotNull(message = "O ID do usuário é obrigatório.")
    Long usuarioId,

    @NotNull (message = "O ID da categoria é obrigatório.")
    Long categoriaId
){}
