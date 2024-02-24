package com.ejercicio.uala.tweet.controller.rest;

import com.ejercicio.uala.tweet.domain.Tweet;
import com.ejercicio.uala.tweet.dto.TweetDTO;
import com.ejercicio.uala.tweet.service.TweetServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TweetRestController {

    private final TweetServiceImpl tweetServiceImpl;

    @PostMapping("/api/tweet")
    @ResponseStatus(HttpStatus.CREATED)
    public TweetDTO crear(@RequestBody Tweet tweet) {
        Tweet tweetCreado = tweetServiceImpl.crear(tweet);
        return new TweetDTO(tweetCreado.getMensaje(), tweetCreado.getUsuarioCreadorId(), tweetCreado.getFechaCreacion());
    }
}
