package com.ejercicio.uala.tweet.repository;


import com.ejercicio.uala.tweet.dto.UsuarioDTO;

public interface UsuarioRepository {
    UsuarioDTO iniciarSesion(String username);

    UsuarioDTO obtenerUsuario(Long id);


}
