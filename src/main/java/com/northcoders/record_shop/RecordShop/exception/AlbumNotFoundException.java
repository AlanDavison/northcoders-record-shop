package com.northcoders.record_shop.RecordShop.exception;

public class AlbumNotFoundException extends RuntimeException {
    private String message;

    public AlbumNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
