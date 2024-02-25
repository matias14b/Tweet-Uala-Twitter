package com.ejercicio.uala.tweet.controller.rest;

import com.ejercicio.uala.tweet.domain.Tweet;
import com.ejercicio.uala.tweet.dto.TweetDTO;
import com.ejercicio.uala.tweet.service.TweetServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/api/timeline/tweets/")
    @ResponseStatus(HttpStatus.CREATED)
    public List<TweetDTO> obtenerTweetsPorUsuariosId(@RequestParam List<String> idUsuarios, @RequestParam String pagina, @RequestParam String tamanio) {
        Pageable pageable = PageRequest.of(Integer.parseInt(pagina), Integer.parseInt(tamanio));
        Page<Tweet> tweet = tweetServiceImpl.obtenerTweetsPorUsuariosId(convertirAListaDeLong(idUsuarios), pageable);
        return mapearADTO(tweet.getContent());
    }

    private List<TweetDTO> mapearADTO(List<Tweet> tweett) {
        return tweett.stream().map(tw -> new TweetDTO(tw.getId(), tw.getMensaje(), tw.getUsuarioCreadorId(), tw.getFechaCreacion())).collect(Collectors.toList());
    }

    private List<Long> convertirAListaDeLong(List<String> idUsuarios) {
        return idUsuarios.stream().map(usuario -> Long.parseLong(usuario.toString())).collect(Collectors.toList());
    }
}
