package com.ejercicio.uala.tweet.service;

import com.ejercicio.uala.tweet.domain.Tweet;
import com.ejercicio.uala.tweet.repository.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;

    public Tweet crear(Tweet tweet) {
        Assert.hasText(tweet.getMensaje(), "El tweet debe contener al menos un carácter.");
        Assert.isTrue(tweet.getMensaje().length() < 250, "El tweet no puede contener mas de 250 caracteres.");
        Assert.notNull(tweet.getUsuarioCreadorId(), "El Usuario creador no puede ser nulo.");

        tweet.setFechaCreacion(LocalDateTime.now());
        return tweetRepository.save(tweet);
    }
}
