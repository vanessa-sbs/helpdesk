package com.technova.helpdesk.repository;

import com.technova.helpdesk.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// A mágica acontece aqui: ao estender JpaRepository,
// o Spring já te dá métodos prontos como save(), findAll(), findById(), delete(), etc.
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // O Spring lê esse nome de metodo e cria a query sozinho!
    // É como se ele traduzisse para: SELECT * FROM usuarios WHERE username = ?
    // O Optional é uma caixinha do Java que pode ou não conter um usuário. Ele nos obriga a verificar se o usuário realmente existe antes de usar, evitando aqueles erros de "NullPointerException"
    Optional<Usuario> findByUsername(String username);
}