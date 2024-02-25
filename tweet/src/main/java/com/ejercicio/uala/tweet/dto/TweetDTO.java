package com.ejercicio.uala.tweet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class TweetDTO implements Serializable {
    private Long id;
    private String mensaje;
    private Long usuarioCreadorId;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fechaCreacion;

    public TweetDTO(String mensaje, Long usuarioCreadorId, LocalDateTime fechaCreacion) {
        this.mensaje = mensaje;
        this.usuarioCreadorId = usuarioCreadorId;
        this.fechaCreacion = fechaCreacion;
    }
}
