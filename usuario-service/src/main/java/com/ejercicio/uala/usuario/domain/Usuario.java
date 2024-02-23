package com.ejercicio.uala.usuario.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class Usuario {
    public Usuario(String username) {
        this.username = username;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private List<Long> seguidosId;
}
