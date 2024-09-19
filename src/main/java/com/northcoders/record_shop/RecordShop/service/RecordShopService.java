package com.northcoders.record_shop.RecordShop.service;

import com.northcoders.record_shop.RecordShop.model.Album;

import java.util.List;

public interface RecordShopService {
    List<Album> getAllAlbums();
    Album addAlbum(Album album);
    Album getAlbumById(Long id);
    Album updateAlbum(Long id, Album album);
    List<Album> addAlbums(Album[] albums);
}
