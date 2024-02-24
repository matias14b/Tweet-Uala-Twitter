package com.ejercicio.uala.tweet.builder.mockWebService;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioMockWebService {

    private int puerto;
    private List<MockResponse> respuestas;

    public static UsuarioMockWebService conPeticion(String puerto) throws IOException {
        UsuarioMockWebService instance = new UsuarioMockWebService();
        instance.puerto = Integer.parseInt(puerto);
        instance.respuestas = new ArrayList<>();
        return instance;
    }

    public UsuarioMockWebService conCredencialesValidas(Long id, String username) throws JSONException {
        MockResponse respuesta = new MockResponse()
                .setResponseCode(HttpStatus.OK.value())
                .setBody(new JSONObject("{\"id\": \"" + id + " \", \"username\": \"" + username + "\"}").toString())
                .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        this.respuestas.add(respuesta);
        return this;
    }

    public UsuarioMockWebService conCredencialesInvalidas() throws IOException {
        MockResponse respuesta = new MockResponse()
                .setResponseCode(HttpStatus.UNAUTHORIZED.value())
                .setBody("Credenciales invalidas.");
        this.respuestas.add(respuesta);
        return this;
    }

    public MockWebServer mock() throws IOException {
        MockWebServer mockWebServer = new MockWebServer();
        mockWebServer.start(this.puerto);
        this.respuestas.forEach(mockWebServer::enqueue);
        return mockWebServer;
    }
}
