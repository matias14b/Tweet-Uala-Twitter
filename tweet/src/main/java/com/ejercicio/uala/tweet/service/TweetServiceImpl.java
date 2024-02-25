package com.ejercicio.uala.tweet.service;

import com.ejercicio.uala.tweet.domain.Tweet;
import com.ejercicio.uala.tweet.dto.TweetDTO;
import com.ejercicio.uala.tweet.dto.UsuarioDTO;
import com.ejercicio.uala.tweet.repository.TweetRepository;
import com.ejercicio.uala.tweet.repository.UsuarioRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;
    private final UsuarioRepositoryImpl usuarioRepository;
    public TweetDTO crear(String username, String mensajeTweet) {
        UsuarioDTO usuarioDTO = usuarioRepository.iniciarSesion(username);

        validarMensaje(mensajeTweet);

        Tweet tweet = tweetRepository.save(armarTweet(mensajeTweet, usuarioDTO));

        return new TweetDTO(tweet.getMensaje(), tweet.getUsuarioCreadorId(), tweet.getFechaCreacion());
    }

    @Override
    public Page<Tweet> obtenerTweetsPorUsuariosId(List<Long> usuariosId, Pageable pageable) {
        return tweetRepository.findAllByUsuarioCreadorIdIn(usuariosId, pageable);
    }

    private void validarMensaje(String mensajeTweet) {
        Assert.hasText(mensajeTweet, "El tweet debe contener al menos un carácter.");
        Assert.isTrue(mensajeTweet.length() < 250, "El tweet no puede contener mas de 250 caracteres.");
    }

    private Tweet armarTweet(String mensajeTweet, UsuarioDTO usuarioDTO) {
        Tweet tweet = new Tweet();
        tweet.setMensaje(mensajeTweet);
        tweet.setUsuarioCreadorId(usuarioDTO.getId());
        tweet.setFechaCreacion(LocalDateTime.now());
        return tweet;
    }
}
