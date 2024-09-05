package com.northcoders.record_shop.RecordShop.model;

public enum Genre {
    ROCK("Rock"),
    PROGROCK("Progressive Rock"),
    METAL("Metal"),
    SKA("Ska"),
    JETHROTULL("Jethro Tull"), // Jethro Tull is a genre.
    POP("Pop"),
    HIPHOP("Hip-Hop"),
    RNB("R&B");

    final String genreDescriptor;

    Genre(String descriptor) {
        this.genreDescriptor = descriptor;
    }
}
