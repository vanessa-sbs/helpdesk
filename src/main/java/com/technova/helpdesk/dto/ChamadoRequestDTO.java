package com.technova.helpdesk.dto;

import com.technova.helpdesk.domain.Prioridade;

public class ChamadoRequestDTO {

    private String titulo;
    private String descricao;
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