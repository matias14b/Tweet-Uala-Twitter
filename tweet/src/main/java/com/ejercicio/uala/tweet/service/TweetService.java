package com.ejercicio.uala.tweet.service;

import com.ejercicio.uala.tweet.domain.Tweet;
import com.ejercicio.uala.tweet.dto.TweetDTO;

import java.util.List;

public interface TweetService {
    TweetDTO crear(String usuario, String tweet);

    List<Tweet> obtenerTweetsPorUsuariosId(List<Long> usuariosId);

}
