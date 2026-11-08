package com.technova.helpdesk.dto;

import java.time.LocalDateTime;

public class ErroResponseDTO {

    private Integer status;
    private String erro;
    private String mensagem;
    private LocalDateTime timestamp;

    public ErroResponseDTO(Integer status, String erro, String mensagem) {
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
        this.timestamp = LocalDateTime.now();
    }

    // Getters e Setters (Alt + Insert)
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public String getErro() { return erro; }
    public void setErro(String erro) { this.erro = erro; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}