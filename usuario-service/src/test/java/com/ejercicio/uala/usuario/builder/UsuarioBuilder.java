package com.ejercicio.uala.usuario.builder;

import com.ejercicio.uala.usuario.domain.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioBuilder {

        private Long id;
        private String username;
        private List<Long> seguidosId;
        private LocalDateTime fechaCreacion;

        public static UsuarioBuilder base() {
            UsuarioBuilder builder = new UsuarioBuilder();
            builder.username = "nombre base";
            builder.seguidosId = new ArrayList<>();
            return builder;
        }

        public UsuarioBuilder conUsername(String username) {
            this.username = username;
            return this;
        }

        public UsuarioBuilder conSeguidosId(List<Long> seguidosId) {
            this.seguidosId = seguidosId;
            return this;
        }

        public Usuario build() {
            Usuario usuario = new Usuario();
            usuario.setUsername(username);
            usuario.setSeguidosId(seguidosId);
            return usuario;
        }

}
