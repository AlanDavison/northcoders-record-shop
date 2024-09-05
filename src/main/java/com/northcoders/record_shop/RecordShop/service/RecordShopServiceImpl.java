package com.northcoders.record_shop.RecordShop.service;

import com.northcoders.record_shop.RecordShop.model.Album;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordShopServiceImpl implements RecordShopService {

    @Override
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = new ArrayList<>();

        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Album> addAlbum(Album album) {
        return null;
    }
}
