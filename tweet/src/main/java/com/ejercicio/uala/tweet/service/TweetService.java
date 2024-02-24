package com.ejercicio.uala.tweet.service;

import com.ejercicio.uala.tweet.domain.Tweet;
import com.ejercicio.uala.tweet.dto.TweetDTO;

public interface TweetService {
    TweetDTO crear(String usuario, String tweet);
}
