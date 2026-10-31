package com.financas.financas_api.dto;

import com.financas.financas_api.model.TipoTransacao;
import com.financas.financas_api.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransacaoResponseDTO (
    Long id,
    String descricao,
    BigDecimal valor,
    LocalDateTime dataHora,
    TipoTransacao tipo,
    
    String nomeUsuario,
    String nomeCategoria
) {
    public TransacaoResponseDTO(Transacao transacao) {
        this(
            transacao.getId(),
            transacao.getDescricao(),
            transacao.getValor(),
            transacao.getDataHora(),
            transacao.getTipo(),
            transacao.getUsuario().getNome(),
            transacao.getCategoria().getNome()
        );
    }
}
