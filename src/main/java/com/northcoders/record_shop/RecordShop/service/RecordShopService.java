package com.northcoders.record_shop.RecordShop.service;

import com.northcoders.record_shop.RecordShop.model.Album;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RecordShopService {
    ResponseEntity<List<Album>> getAllAlbums();
    ResponseEntity<Album> addAlbum(Album album);
}
