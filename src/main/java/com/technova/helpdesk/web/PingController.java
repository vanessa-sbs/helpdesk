package com.technova.helpdesk.web;
// Um controller é a classe que mapeia as URLs da sua API. É o ponto onde a internet "bate na sua porta". Ele escuta o que o cliente quer e devolve a resposta certa.
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //esta classe responde requisições HTTP; o que os métodos retornarem vira o corpo da resposta (não um nome de página HTML)
public class PingController {
    @GetMapping("/ping") //quando chegar um GET em /ping, invoque este método
    public String ping(){
        return "pong";
    }
}
