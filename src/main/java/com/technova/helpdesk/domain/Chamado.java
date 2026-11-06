package com.technova.helpdesk.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 2000) // A especificação permite até 2000 caracteres
    private String descricao;

    // O EnumType.STRING é OBRIGATÓRIO aqui.
    // Ele diz: "Salve a palavra 'ALTA' no banco, e não o número 2".
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusChamado status = StatusChamado.ABERTO; // Já começa como ABERTO por padrão

    private LocalDateTime criadoEm = LocalDateTime.now();

    // O RELACIONAMENTO ENTRA AQUI:
    @ManyToOne // Muitos chamados para Um usuário
    @JoinColumn(name = "usuario_id", nullable = false) // Cria a coluna 'usuario_id' na tabela de chamados. Obrigatório.
    private Usuario usuario;

    // --- Getters e Setters ---
    // (Aperte Alt + Insert -> Getter and Setter para gerar todos)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Prioridade getPrioridade() { return prioridade; }
    public void setPrioridade(Prioridade prioridade) { this.prioridade = prioridade; }

    public StatusChamado getStatus() { return status; }
    public void setStatus(StatusChamado status) { this.status = status; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}