package com.northcoders.record_shop.RecordShop.service;

import com.northcoders.record_shop.RecordShop.model.Album;

import java.util.List;

public interface RecordShopService {
    List<Album> getAllAlbums();
    Album addAlbum(Album album);
}
