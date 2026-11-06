package com.technova.helpdesk.controller;

import com.technova.helpdesk.domain.Chamado;
import com.technova.helpdesk.dto.ChamadoRequestDTO;
import com.technova.helpdesk.service.ChamadoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chamados") // Todas as rotas aqui começarão com /chamados
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Força o status 201 (Created)
    public Chamado criar(@RequestBody ChamadoRequestDTO dto) {
        // O @RequestBody pega o JSON que o cliente mandou e transforma no nosso DTO
        return chamadoService.criar(dto);
    }
}