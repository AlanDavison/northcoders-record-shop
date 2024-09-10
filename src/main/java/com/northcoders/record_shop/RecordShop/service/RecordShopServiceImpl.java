package com.northcoders.record_shop.RecordShop.service;

import com.northcoders.record_shop.RecordShop.cache.AlbumRequestCache;
import com.northcoders.record_shop.RecordShop.exception.AlbumNotFoundException;
import com.northcoders.record_shop.RecordShop.model.Album;
import com.northcoders.record_shop.RecordShop.repository.RecordShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecordShopServiceImpl implements RecordShopService {

    @Autowired
    private RecordShopRepository repo;

    @Autowired
    private AlbumRequestCache albumRequest;

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
        this.albumRequest.invalidateCacheForAlbum(album);
        this.repo.save(album);
        return album;
    }

    @Override
    public Album getAlbumById(Long id) {
        Optional<Album> cachedAlbum = this.albumRequest.getAlbumById(id);

        if (cachedAlbum.isPresent())
            return cachedAlbum.get();

        Optional<Album> albumFromRepo = this.repo.findById(id);

        if (albumFromRepo.isPresent())
            return albumFromRepo.get();

        throw new AlbumNotFoundException(String.format("Album with ID %d not found.", id));
    }
}
