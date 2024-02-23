package com.ejercicio.uala.usuario.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Usuario {
    private long id;
    private String username;
    private List<Long> seguidoresId;
}
