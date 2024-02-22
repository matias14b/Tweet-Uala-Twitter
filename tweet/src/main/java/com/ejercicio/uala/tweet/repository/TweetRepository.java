package com.ejercicio.uala.tweet.repository;

import com.ejercicio.uala.tweet.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
