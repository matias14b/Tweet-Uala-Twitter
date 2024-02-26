package com.ejercicio.uala.tweet.controller.rest;

import com.ejercicio.uala.tweet.domain.Tweet;
import com.ejercicio.uala.tweet.dto.TweetDTO;
import com.ejercicio.uala.tweet.service.TweetServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TweetRestController {

    private final TweetServiceImpl tweetServiceImpl;

    @PostMapping("/api/{username}/tweet")
    @ResponseStatus(HttpStatus.CREATED)
    public TweetDTO crear(@PathVariable String username, @RequestBody String tweet) {
        return tweetServiceImpl.crear(username, tweet);
    }

    @GetMapping("/api/{idUsuario}/tweets/")
    @ResponseStatus(HttpStatus.CREATED)
    public List<TweetDTO> obtenerTweetsPorUsuarioId(@PathVariable long idUsuario, Pageable pageable) {
        Page<Tweet> tweet = tweetServiceImpl.obtenerTweetsPorUsuarioId(idUsuario, pageable);
        return mapearADTO(tweet.getContent());
    }

    private List<TweetDTO> mapearADTO(List<Tweet> tweett) {
        return tweett.stream().map(tw -> new TweetDTO(tw.getId(), tw.getMensaje(), tw.getUsuarioCreadorId(), tw.getFechaCreacion())).collect(Collectors.toList());
    }
}
