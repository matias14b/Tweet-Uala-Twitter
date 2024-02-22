package com.ejercicio.uala.tweet.controller.rest;

import com.ejercicio.uala.tweet.domain.Tweet;
import com.ejercicio.uala.tweet.dto.TweetDTO;
import com.ejercicio.uala.tweet.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TweetRestController {

    private final TweetService tweetService;

    @PostMapping("/api/tweet")
    @ResponseStatus(HttpStatus.CREATED)
    public TweetDTO crear(@RequestBody Tweet tweet) {
        Tweet tweetCreado = tweetService.crear(tweet);
        return new TweetDTO(tweetCreado.getMensaje(), tweetCreado.getUsuarioCreadorId(), tweetCreado.getFechaCreacion());
    }
}
