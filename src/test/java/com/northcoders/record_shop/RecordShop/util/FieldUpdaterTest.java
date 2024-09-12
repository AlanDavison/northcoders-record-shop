package com.northcoders.record_shop.RecordShop.util;

import com.northcoders.record_shop.RecordShop.model.Album;
import com.northcoders.record_shop.RecordShop.model.AlbumType;
import com.northcoders.record_shop.RecordShop.model.Artist;
import com.northcoders.record_shop.RecordShop.model.Genre;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class FieldUpdaterTest {

    @Test
    void updateFieldsWhereNotNull() {
        HashSet<Artist> artistSet = new HashSet<>();
        artistSet.add(new Artist("Fake Jethro Tull", "image.jpg", new HashSet<Album>()));

        Album originalAlbum = new Album(
                1L,
                artistSet,
                "First Album",
                "A good album.",
                "image.jpg",
                Genre.JETHROTULL,
                AlbumType.CASSETTE,
                10L,
                new BigDecimal(10.00)
        );
        Album albumChanges = new Album(
                null,
                new HashSet<Artist>(),
                null,
                null,
                "new-image.jpg",
                null,
                null,
                9L,
                new BigDecimal(9.00)
        );
        Album desiredResult = new Album(
                1L,
                artistSet,
                "First Album",
                "A good album.",
                "new-image.jpg",
                Genre.JETHROTULL,
                AlbumType.CASSETTE,
                9L,
                new BigDecimal(9.00)
        );

        assertDoesNotThrow(() -> FieldUpdater.updateFieldsWhereNotNull(albumChanges, originalAlbum));

        assertEquals(originalAlbum.getId(), desiredResult.getId());
        assertEquals(originalAlbum.getCost(), desiredResult.getCost());
        assertEquals(originalAlbum.getName(), desiredResult.getName());
        assertEquals(originalAlbum.getGenre(), desiredResult.getGenre());
        assertEquals(originalAlbum.getType(), desiredResult.getType());
        assertEquals(originalAlbum.getAlbumArtUrl(), desiredResult.getAlbumArtUrl());
        assertEquals(originalAlbum.getStockCount(), desiredResult.getStockCount());
        assertEquals(originalAlbum.getDescription(), desiredResult.getDescription());
        assertEquals(originalAlbum.getArtists(), desiredResult.getArtists());
    }
}