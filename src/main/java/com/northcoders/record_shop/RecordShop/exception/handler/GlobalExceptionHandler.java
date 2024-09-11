package com.northcoders.record_shop.RecordShop.exception.handler;

import com.northcoders.record_shop.RecordShop.exception.AlbumNotFoundException;
import com.northcoders.record_shop.RecordShop.exception.ArtistNotFoundException;
import com.northcoders.record_shop.RecordShop.exception.IncorrectHttpRequestType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({AlbumNotFoundException.class})
    public ResponseEntity<Object> handleAlbumNotFoundException(AlbumNotFoundException e) {
        return this.respondToGenericExceptionMessage(e);
    }

    @ExceptionHandler({ArtistNotFoundException.class})
    public ResponseEntity<Object> handleArtistNotFoundException(ArtistNotFoundException e) {
        return this.respondToGenericExceptionMessage(e);
    }

    @ExceptionHandler({IncorrectHttpRequestType.class})
    private ResponseEntity<Object> handleIncorrectHttpRequestTypeException(IncorrectHttpRequestType e) {
        return this.respondToGenericExceptionMessage(e);
    }

    private ResponseEntity<Object> respondToGenericExceptionMessage(RuntimeException e) {
        this.logger.error(e.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}
