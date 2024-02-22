package com.ejercicio.uala.tweet.dto;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
public class TweetDTO implements Serializable {
    private String mensaje;
    private Long usuarioCreadorId;
    private LocalDateTime fechaCreacion;
}
