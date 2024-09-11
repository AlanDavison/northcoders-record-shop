package com.northcoders.record_shop.RecordShop.service;

import com.northcoders.record_shop.RecordShop.model.Album;
import com.northcoders.record_shop.RecordShop.model.Artist;

import java.util.List;

public interface RecordShopService {
    List<Album> getAllAlbums();
    Album addAlbum(Album album);
    Album getAlbumById(Long id);
    Artist updateAlbum(Long id, Album album);
    Artist addArtist(Artist artist);
    Artist getArtistById(Long id);
    Artist updateArtistById(Long id, Artist artist);
}
