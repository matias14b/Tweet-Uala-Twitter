package com.ejercicio.uala.tweet.builder;

import com.ejercicio.uala.tweet.domain.Tweet;

import java.time.LocalDateTime;

public class TweetBuilder {

    private final Tweet tweet;

    private TweetBuilder() {
        tweet = new Tweet();
    }

    public static TweetBuilder valido(){
      TweetBuilder tweetBuilder = new TweetBuilder();
      tweetBuilder.tweet.setMensaje("Mensaje valido");
      tweetBuilder.tweet.setFechaCreacion(LocalDateTime.now());
      tweetBuilder.tweet.setUsuarioCreadorId(1);
      return tweetBuilder;
    }

    public static TweetBuilder invalido(){
        TweetBuilder tweetBuilder = new TweetBuilder();
        tweetBuilder.tweet.setMensaje("Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje inval");
        return tweetBuilder;
    }

    public Tweet conMensaje(String mensaje) {
        tweet.setMensaje(mensaje);
        return tweet;
    }

    public Tweet conFechaCreacion(LocalDateTime fechaCreacion) {
        tweet.setFechaCreacion(fechaCreacion);
        return tweet;
    }

    public Tweet conUsuarioCreadorId(Long id) {
        tweet.setUsuarioCreadorId(id);
        return tweet;
    }
}
