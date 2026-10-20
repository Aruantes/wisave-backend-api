package com.financas.financas_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column (nullable = false, unique = true, length = 150)
    private String email;

    @Column (name = "senha_hash", nullable = false)
    private String senhaHash;

    @Column (name = "criado_em", nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();
}
