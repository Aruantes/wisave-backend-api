package com.financas.financas_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table (name = "transacoes")
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
@EqualsAndHashCode (of = "id")

public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String descricao;
    
    @Column (nullable = false, precision = 19, scale = 2)
    private BigDecimal valor;

    @Column (nullable = false)
    private LocalDateTime dataHora;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false)
    private TipoTransacao tipo;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "categoria_id", nullable = false)
    private Categoria categoria;
}
