package com.finance.finance_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String name;

    @Column (nullable = false, unique = true, length = 150)
    private String email;

    @ToString.Exclude
    @Column(name = "senha_hash", nullable = false)
    private String passwordHash;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
