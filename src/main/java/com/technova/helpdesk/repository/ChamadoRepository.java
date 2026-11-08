package com.technova.helpdesk.repository;

import com.technova.helpdesk.domain.Chamado;
import com.technova.helpdesk.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    // Vamos adicionar os filtros de busca
    List<Chamado> findByUsuario(Usuario usuario);

    Optional<Chamado> findByIdAndUsuario(Long id, Usuario usuario);
}