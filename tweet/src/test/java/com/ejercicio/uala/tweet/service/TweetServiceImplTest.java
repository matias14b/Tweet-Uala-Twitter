package com.ejercicio.uala.tweet.service;


import com.ejercicio.uala.tweet.builder.TweetBuilder;
import com.ejercicio.uala.tweet.builder.mockWebServer.UsuarioMockWebServer;
import com.ejercicio.uala.tweet.domain.Tweet;
import com.ejercicio.uala.tweet.dto.TweetDTO;
import okhttp3.mockwebserver.MockWebServer;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class TweetServiceImplTest {

    @Value("${uala.twitter.servicio.usuario}")
    private String apiUrlServicioUsuario;

    @Autowired
    private TweetServiceImpl tweetServiceImpl;

    @Test
    public void crear_conInformacionValida_guardaTweetYEscribeUsuarioCreadorId() throws IOException, JSONException {
        String usuario = "ichiban";
        String tweet = "mensaje valido";

        try (MockWebServer mockWebServer = UsuarioMockWebServer.conPeticion(apiUrlServicioUsuario).conCredencialesValidas(1L, usuario).mock()) {
            TweetDTO tweetGuardado = tweetServiceImpl.crear(usuario, tweet);
            assertThat(tweetGuardado).isNotNull();
            assertThat(tweetGuardado.getUsuarioCreadorId()).isEqualTo(1);
        }
    }

    @Test
    public void crear_conInformacionInvalidaMensajeSupera280Caracteres_lanzaExcepcion() throws IOException, JSONException {
        String usuario = "ichiban";
        String mensaje = "Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje inval";

        try (MockWebServer mockWebServer = UsuarioMockWebServer.conPeticion(apiUrlServicioUsuario).conCredencialesValidas(1L, usuario).mock()) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> tweetServiceImpl.crear(usuario, mensaje))
                    .withMessage("El tweet no puede contener mas de 250 caracteres.");
        }
    }

    @Test
    public void crear_conInformacionInvalidaMensajeVacio_lanzaExcepcion() throws IOException, JSONException {
        String usuario = "ichiban";
        String mensaje = "";

        try (MockWebServer mockWebServer = UsuarioMockWebServer.conPeticion(apiUrlServicioUsuario).conCredencialesValidas(1L, usuario).mock()) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> tweetServiceImpl.crear(usuario, mensaje))
                    .withMessage("El tweet debe contener al menos un carácter.");
        }
    }

    @Test
    public void crear_conInformacionInvalidaMensajeConSoloEspacios_lanzaExcepcion() throws IOException, JSONException {
        String usuario = "ichiban";
        String mensaje = "   ";
        try (MockWebServer mockWebServer = UsuarioMockWebServer.conPeticion(apiUrlServicioUsuario).conCredencialesValidas(1L, usuario).mock()) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> tweetServiceImpl.crear(usuario, mensaje))
                    .withMessage("El tweet debe contener al menos un carácter.");
        }
    }

    @Test
    public void crear_conInformacionInvalidaMensajeNulo_lanzaExcepcion() throws IOException, JSONException {
        String usuario = "ichiban";
        String mensaje = null;
        try (MockWebServer mockWebServer = UsuarioMockWebServer.conPeticion(apiUrlServicioUsuario).conCredencialesValidas(1L, usuario).mock()) {

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> tweetServiceImpl.crear(usuario, mensaje))
                    .withMessage("El tweet debe contener al menos un carácter.");
        }
    }

    @Test
    public void crear_conDatosValidos_guardaTweetConFechaDeCreacion() throws IOException, JSONException {
        String usuario = "ichiban";
        String mensaje = "mensaje";

        try (MockWebServer mockWebServer = UsuarioMockWebServer.conPeticion(apiUrlServicioUsuario).conCredencialesValidas(1L, usuario).mock()) {

            TweetDTO tweetGuardado = tweetServiceImpl.crear(usuario, mensaje);

            assertThat(tweetGuardado.getFechaCreacion()).isNotNull();
        }
    }

    @Test
    public void crear_conUsuarioCreadorInvalido_lanzaExcepcion() throws IOException {
        String usuario = "ochiban";
        String mensaje = "mensaje";

        try (MockWebServer mockWebServer = UsuarioMockWebServer.conPeticion(apiUrlServicioUsuario).conCredencialesInvalidas().mock()) {

            assertThatExceptionOfType(HttpClientErrorException.Unauthorized.class).isThrownBy(()
                    -> tweetServiceImpl.crear(usuario, mensaje))
                    .withMessage("401 Unauthorized: \"Credenciales invalidas.\"");
        }
    }
}
