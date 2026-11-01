package com.finance.finance_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacoes")
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
@EqualsAndHashCode (of = "id")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String description;
    
    @Column(name = "valor", nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated (EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TransactionType type;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private User user;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Category category;
}
