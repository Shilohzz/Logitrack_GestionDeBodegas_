package com.logitrack.logitrack.repository;

import com.logitrack.logitrack.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmailInstitucional(String email);
}