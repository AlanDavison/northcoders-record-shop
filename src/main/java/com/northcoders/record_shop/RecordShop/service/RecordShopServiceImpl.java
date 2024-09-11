package com.northcoders.record_shop.RecordShop.service;

import com.northcoders.record_shop.RecordShop.exception.AlbumNotFoundException;
import com.northcoders.record_shop.RecordShop.model.Album;
import com.northcoders.record_shop.RecordShop.model.Artist;
import com.northcoders.record_shop.RecordShop.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecordShopServiceImpl implements RecordShopService {

    @Autowired
    private RecordRepository repo;

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

    @Override
    public Album getAlbumById(Long id) {
        Optional<Album> foundAlbum = this.repo.findById(id);

        if (foundAlbum.isPresent())
            return foundAlbum.get();

        throw new AlbumNotFoundException(String.format("Album with ID %d not found.", id));
    }

    @Override
    public Artist updateAlbum(Long id, Album album) {
        return null;
    }

    @Override
    public Artist addArtist(Artist artist) {

    }

    @Override
    public Artist getArtistById(Long id) {
        return null;
    }

    @Override
    public Artist updateArtistById(Long id, Artist artist) {
        return null;
    }
}
