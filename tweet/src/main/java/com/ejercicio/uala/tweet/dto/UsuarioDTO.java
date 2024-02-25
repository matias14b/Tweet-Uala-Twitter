package com.ejercicio.uala.tweet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class UsuarioDTO implements Serializable {
    private Long id;
    private String username;
    private List<Long> seguidosId;
}
