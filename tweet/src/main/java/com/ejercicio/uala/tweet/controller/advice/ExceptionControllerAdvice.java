package com.ejercicio.uala.tweet.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    private static final String MENSAJE_DEFAULT = "Se produjo un error inesperado. Intente nuevamente.";

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException exception) {
        log.debug("[Error por IllegalArgumentException]: [{}] -- Stack trace: [{}]", exception.getMessage(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleDefaultException(Exception exception) {
        log.error("Error por Exception: Mensaje: [{}] -- Stack trace: [{}]", exception.getMessage(), exception);
        return new ResponseEntity<>(MENSAJE_DEFAULT, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
