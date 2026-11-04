package com.technova.helpdesk.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Diz ao banco: "Crie uma tabela para essa classe"
@Table(name = "usuarios") // Dá um nome à tabela (evita conflito com a palavra "user", que é reservada no SQL)
public class Usuario {

    @Id // Diz que esse campo é a Chave Primária (o identificador único)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco gera o ID sozinho (1, 2, 3...)
    private Long id;

    @Column(nullable = false, length = 100) // Obrigatório, máximo 100 caracteres
    private String nome;

    @Column(nullable = false, unique = true, length = 30) // Obrigatório e Único (não pode ter dois iguais)
    private String username;

    @Column(nullable = false)
    private String password;

    private LocalDateTime criadoEm = LocalDateTime.now(); // Salva a data/hora exata da criação

    // --- Getters e Setters ---
    // O Spring precisa deles para ler e alterar os dados.
    // (No IntelliJ, você pode apagar esta parte e apertar Alt + Insert -> Getter and Setter -> Selecionar todos)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
}