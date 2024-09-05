package com.northcoders.record_shop.RecordShop.service;

import com.northcoders.record_shop.RecordShop.model.Album;
import com.northcoders.record_shop.RecordShop.repository.RecordShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordShopServiceImpl implements RecordShopService {

    @Autowired
    private RecordShopRepository repo;

    @Override
    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();

        for (Album a: this.repo.findAll()) {
            albums.add(a);
        }

        return albums;
    }

    @Override
    public Album addAlbum(Album album) {
        this.repo.save(album);
        return album;
    }
}
