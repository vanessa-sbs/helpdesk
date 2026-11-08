package com.technova.helpdesk.dto;

import com.technova.helpdesk.domain.StatusChamado;
import jakarta.validation.constraints.NotNull;

public class StatusRequestDTO {

    @NotNull(message = "O novo status é obrigatório.")
    private StatusChamado status;

    // Getter e Setter
    public StatusChamado getStatus() { return status; }
    public void setStatus(StatusChamado status) { this.status = status; }
}