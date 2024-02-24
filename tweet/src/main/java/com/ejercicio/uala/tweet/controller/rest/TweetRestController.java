package com.ejercicio.uala.tweet.controller.rest;

import com.ejercicio.uala.tweet.domain.Tweet;
import com.ejercicio.uala.tweet.dto.TweetDTO;
import com.ejercicio.uala.tweet.service.TweetServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TweetRestController {

    private final TweetServiceImpl tweetServiceImpl;

    @PostMapping("/api/{username}/tweet")
    @ResponseStatus(HttpStatus.CREATED)
    public TweetDTO crear(@PathVariable String username, @RequestBody String tweet) {
        return tweetServiceImpl.crear(username, tweet);
    }
}
