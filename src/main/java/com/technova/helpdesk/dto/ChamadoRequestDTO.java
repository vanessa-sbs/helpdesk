package com.technova.helpdesk.dto;

import com.technova.helpdesk.domain.Prioridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ChamadoRequestDTO {

    @NotBlank(message = "O titulo e obrigatorio.")
    @Size(min=5, max=100, message="O titulo deve ter entre 5 e 100 caracteres.")
    private String titulo;

    @NotBlank(message="Adescricao e obrigatoria.")
    @Size(max=2000, message="A descriçao deve ter no maximo 2000 caracteres.")
    private String descricao;

    @NotNull(message="Aprioridade e obrigatoria.")
    private Prioridade prioridade;


    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }
    // Getters e Setters aqui! (Alt + Insert -> Getter and Setter)

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
}