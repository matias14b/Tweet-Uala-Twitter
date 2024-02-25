package com.ejercicio.uala.tweet.service;

import com.ejercicio.uala.tweet.domain.Tweet;
import com.ejercicio.uala.tweet.dto.TweetDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TweetService {
    TweetDTO crear(String usuario, String tweet);

    Page<Tweet> obtenerTweetsPorUsuarioId(Long usuariosId, Pageable pageable);

}
