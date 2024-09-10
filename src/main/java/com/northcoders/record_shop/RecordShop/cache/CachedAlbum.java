package com.northcoders.record_shop.RecordShop.cache;

import com.northcoders.record_shop.RecordShop.model.Album;
import lombok.Getter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

public class CachedAlbum {
    @Getter
    private final Album album;
    private final Instant timeOfInsertion;

    public CachedAlbum(Album album) {
        this.album = album;
        this.timeOfInsertion = Instant.now();
    }

    public Boolean isExpired() {
        return this.timeOfInsertion.plus(10L, ChronoUnit.MINUTES).isBefore(Instant.now());
    }
}
