package com.northcoders.record_shop.RecordShop.service;

import com.northcoders.record_shop.RecordShop.model.Album;
import com.northcoders.record_shop.RecordShop.model.Artist;

import java.util.List;

public interface RecordShopService {
    List<Album> getAllAlbums();
    Album addAlbum(Album album);
    Album getAlbumById(Long id);
    Album updateAlbum(Long id, Album album);
    List<Artist> getAllArtists();
    Artist addArtist(Artist artist);
    Artist getArtistById(String id);
    Artist updateArtistById(String id, Artist artist);
    List<Album> addAlbums(Album[] albums);
    List<Artist> addArtists(Artist[] artists);
}
