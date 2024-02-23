package com.ejercicio.uala.usuario.repository;

import com.ejercicio.uala.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
