package com.ejercicio.uala.tweet.builder;

import com.ejercicio.uala.tweet.domain.Tweet;

import java.time.LocalDateTime;

public class TweetBuilder {

    private Long id;
    private String mensaje;
    private Long usuarioCreadorId;
    private LocalDateTime fechaCreacion;

    public static TweetBuilder base() {
        TweetBuilder builder = new TweetBuilder();
        builder.mensaje = "mensaje base";
        builder.usuarioCreadorId = 1L;
        return builder;
    }

    public TweetBuilder conMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    public TweetBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public TweetBuilder conUsuarioCreacionId(Long id) {
        this.usuarioCreadorId = id;
        return this;
    }

    public TweetBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public Tweet build() {
        Tweet tweet = new Tweet();
        tweet.setId(id);
        tweet.setMensaje(mensaje);
        tweet.setFechaCreacion(fechaCreacion);
        tweet.setUsuarioCreadorId(usuarioCreadorId);
        return tweet;
    }
}
