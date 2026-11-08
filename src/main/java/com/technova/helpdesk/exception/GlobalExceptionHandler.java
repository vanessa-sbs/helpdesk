package com.technova.helpdesk.exception;

import com.technova.helpdesk.dto.ErroResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Diz ao Spring: "Essa classe é o fiscal global de erros"
public class GlobalExceptionHandler {

    // 1. Captura erros de validação (quando o @Valid falha)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Pega a primeira mensagem de erro que definimos no DTO
        String mensagemErro = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();

        ErroResponseDTO erro = new ErroResponseDTO(400, "Bad Request", mensagemErro);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
    // Isso garante que, se o JSON estiver errado, a API responde 400 e não 404
    // pois o JSON mal formataodo eh erro de cliente
    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResponseDTO> handleJsonError(org.springframework.http.converter.HttpMessageNotReadableException ex) {
        ErroResponseDTO erro = new ErroResponseDTO(400, "Bad Request", "O corpo da requisição está mal formatado. Verifique o JSON.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    // 2. Captura exceções genéricas (como a nossa RuntimeException do Service)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroResponseDTO> handleRuntimeExceptions(RuntimeException ex) {
        // No futuro, vamos melhorar isso para diferenciar 404 de 400.
        // Por enquanto, o erro de "não encontrado" vai cair aqui.
        ErroResponseDTO erro = new ErroResponseDTO(404, "Not Found", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

}