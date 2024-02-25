package com.ejercicio.uala.tweet.repository;

import com.ejercicio.uala.tweet.domain.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends PagingAndSortingRepository<Tweet, Long>, JpaRepository<Tweet, Long> {
    Page<Tweet> findAllByUsuarioCreadorIdIn(List<Long> usuarioCreadorId, Pageable pageable);
}
