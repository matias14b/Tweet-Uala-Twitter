package com.ejercicio.uala.tweet.service;


import com.ejercicio.uala.tweet.builder.TweetBuilder;
import com.ejercicio.uala.tweet.domain.Tweet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SpringBootTest
public class TweetServiceTest {

    @Autowired
    private TweetService tweetService;

    @Test
    public void crear_conInformacionValida_guardaTweet() {
        Tweet tweet = TweetBuilder.valido().conMensaje("mensaje de ejemplo");

        Tweet tweetGuardado = tweetService.crear(tweet);

        assertThat(tweetGuardado).isNotNull();
    }

    @Test
    public void crear_conInformacionInvalidaMensajeSupera280Caracteres_lanzaExcepcion() {
        Tweet tweet = TweetBuilder
                .invalido()
                .conMensaje("Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje invalido Mensaje inval");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> tweetService.crear(tweet))
                .withMessage("El tweet no puede contener mas de 250 caracteres.");
    }

    @Test
    public void crear_conInformacionInvalidaMensajeVacio_lanzaExcepcion() {
        Tweet tweet = TweetBuilder
                .invalido()
                .conMensaje("");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> tweetService.crear(tweet))
                .withMessage("El tweet debe contener al menos un carácter.");
    }

    @Test
    public void crear_conInformacionInvalidaMensajeConSoloEspacios_lanzaExcepcion() {
        Tweet tweet = TweetBuilder
                .invalido()
                .conMensaje("      ");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> tweetService.crear(tweet))
                .withMessage("El tweet debe contener al menos un carácter.");
    }

    @Test
    public void crear_conInformacionInvalidaMensajeNulo_lanzaExcepcion() {
        Tweet tweet = TweetBuilder
                .invalido()
                .conMensaje(null);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> tweetService.crear(tweet))
                .withMessage("El tweet debe contener al menos un carácter.");
    }

    @Test
    public void crear_conFechaDeCreacion_guardaTweetConFechaDeCreacion() {
        Tweet tweet = TweetBuilder.valido().conFechaCreacion(LocalDateTime.now());

        Tweet tweetGuardado = tweetService.crear(tweet);

        assertThat(tweetGuardado.getFechaCreacion()).isEqualTo(tweet.getFechaCreacion());
    }

    @Test
    public void crear_conUsuarioCreadorId_guardaTweetConUsuarioCreadorId() {
        Tweet tweet = TweetBuilder.valido().conUsuarioCreadorId(1L);

        Tweet tweetGuardado = tweetService.crear(tweet);

        assertThat(tweetGuardado.getFechaCreacion()).isEqualTo(tweet.getFechaCreacion());
    }
}
