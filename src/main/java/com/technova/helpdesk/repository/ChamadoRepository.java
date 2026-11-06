package com.technova.helpdesk.repository;

import com.technova.helpdesk.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    // Vamos adicionar os filtros de busca daqui a pouco.
}