package com.technova.helpdesk.service;

import com.technova.helpdesk.domain.Chamado;
import com.technova.helpdesk.domain.StatusChamado;
import com.technova.helpdesk.domain.Usuario;
import com.technova.helpdesk.dto.ChamadoRequestDTO;
import com.technova.helpdesk.dto.StatusRequestDTO;
import com.technova.helpdesk.repository.ChamadoRepository;
import com.technova.helpdesk.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Diz ao Spring que essa classe é a "cozinha" (regra de negócio)
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;
    private final UsuarioRepository usuarioRepository;

    // INJEÇÃO DE DEPENDÊNCIA: O Spring entrega esses repositórios prontos pra gente!
    public ChamadoService(ChamadoRepository chamadoRepository, UsuarioRepository usuarioRepository) {
        this.chamadoRepository = chamadoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Chamado criar(ChamadoRequestDTO dto) {
        // 1. Transforma o DTO em Entidade Chamado
        Chamado chamado = new Chamado();
        chamado.setTitulo(dto.getTitulo());
        chamado.setDescricao(dto.getDescricao());
        chamado.setPrioridade(dto.getPrioridade());

        // O status inicial já foi definido na entidade como ABERTO.

        // 2. Achar o usuário dono do chamado.
        // NOTA: Aqui estamos usando um usuário fixo "vanessa" só para testar,
        // porque ainda não temos o token. Na Aula 08, isso virá do token.
        Usuario usuario = usuarioRepository.findByUsername("vanessa")
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        chamado.setUsuario(usuario);

        // 3. Salva no banco e retorna o chamado salvo (já com ID)
        return chamadoRepository.save(chamado);
    }

    public List<Chamado> listarMeusChamados() {
        // 1. O Service vai no banco e busca o usuário (nossa "Vanessa" fixa)
        Usuario usuario = usuarioRepository.findByUsername("vanessa")
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // 2. Agora que sabemos quem é o usuário, pedimos ao repositório para buscar os chamados dele
        return chamadoRepository.findByUsuario(usuario);
    }

    public Chamado atualizarStatus(Long id, StatusRequestDTO dto) {
        // 1. Busca o chamado (por enquanto, ainda preso à Vanessa)
        Usuario usuario = usuarioRepository.findByUsername("vanessa")
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Chamado chamado = chamadoRepository.findByIdAndUsuario(id, usuario)
                .orElseThrow(() -> new RuntimeException("Chamado " + id + " não encontrado"));

        // 2. Aplica a regra de transição
        if (chamado.getStatus() == StatusChamado.FECHADO ) {
            // Se cair aqui, disparamos um erro (que o nosso Fiscal vai transformar em JSON)
            throw new RuntimeException("Um chamado FECHADO não pode ser alterado.");
        }

        // 3. Atualiza o status e salva
        chamado.setStatus(dto.getStatus());
        return chamadoRepository.save(chamado);
    }
}