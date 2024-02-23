package com.ejercicio.uala.usuario.service;

import com.ejercicio.uala.usuario.domain.Usuario;

public interface UsuarioService {
    boolean validarExisteUsuario(Long id);

    Usuario seguir(Long idUsuarioSeguidor, Long idUsuarioSeguido);
}

