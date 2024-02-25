package com.ejercicio.uala.tweet.repository;

import com.ejercicio.uala.tweet.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Value("${uala.twitter.servicio.usuario}")
    private String puerto;
    private String urlBase = "http://localhost:";
    private final RestClient restClient = RestClient.create();

    @Override
    public UsuarioDTO iniciarSesion(String username) {
        return restClient.get()
                .uri(urlBase + puerto + "/api/usuario/" + username)
                .retrieve()
                .body(UsuarioDTO.class);
    }

    public UsuarioDTO obtenerUsuario(Long id) {
        return restClient.method(HttpMethod.GET)
                .uri(urlBase + puerto + "/api/usuario/" + id + "/seguidos")
                .retrieve()
                .body(UsuarioDTO.class);
    }
}
