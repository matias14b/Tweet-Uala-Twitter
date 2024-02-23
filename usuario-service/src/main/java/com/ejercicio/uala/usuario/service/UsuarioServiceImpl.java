package com.ejercicio.uala.usuario.service;

import com.ejercicio.uala.usuario.domain.Usuario;
import com.ejercicio.uala.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public boolean validarExisteUsuario(Long id) {
        return usuarioRepository.existsById(id);
    }

    @Override
    public Usuario seguir(Long idUsuarioSeguidor, Long idUsuarioSeguido) {
        throw new UnsupportedOperationException("no");
    }
}
