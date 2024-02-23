package com.ejercicio.uala.usuario.service;

import com.ejercicio.uala.usuario.builder.UsuarioBuilder;
import com.ejercicio.uala.usuario.domain.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UsuarioServiceImplTest {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    @Transactional
    void validarExisteUsuario_conIdUsuarioExistente_retornaTrue() {
        Usuario usuario = UsuarioBuilder.base().conUsername("Ejemplo").build();
        persistirEnBase(usuario);

        assertThat(usuarioServiceImpl.validarExisteUsuario(usuario.getId())).isTrue();
    }

    @Test
    void validarExisteUsuario_conIdUsuarioInexistente_retornaFalse() {
        assertThat(usuarioServiceImpl.validarExisteUsuario(1L)).isFalse();
    }

    @Test
    @Transactional
    void seguirUsuario_conUsuarioSeguidoExistenteYUsuarioSeguidorExistente_retornaUsuarioSeguidorConIdDeUsuarioSeguido() {
        Usuario usuarioSeguidor = UsuarioBuilder
                .base()
                .conUsername("Seguidor")
                .conSeguidosId(null)
                .build();
        persistirEnBase(usuarioSeguidor);

        Usuario usuarioSeguido = UsuarioBuilder
                .base()
                .conUsername("Seguido")
                .build();
        persistirEnBase(usuarioSeguido);

        Usuario usuarioSeguidorConIdDeUsuarioSeguido = usuarioServiceImpl.seguir(usuarioSeguidor.getId(), usuarioSeguido.getId());

        assertThat(usuarioSeguidorConIdDeUsuarioSeguido.getSeguidosId()).contains(usuarioSeguido.getId());
    }

    private void persistirEnBase(Usuario usuario) {
        entityManager.persist(usuario);
        entityManager.flush();
        entityManager.detach(usuario);
    }
}