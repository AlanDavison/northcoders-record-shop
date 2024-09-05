package com.northcoders.record_shop.RecordShop.model;

public enum AlbumType {
    CD("CD"),
    LP("LP/Vinyl"),
    CASSETTE("Cassette");

    final String albumTypeDescriptor;

    AlbumType(String descriptor) {
        this.albumTypeDescriptor = descriptor;
    }
}
