package com.northcoders.record_shop.RecordShop.service;

import com.northcoders.record_shop.RecordShop.exception.AlbumNotFoundException;
import com.northcoders.record_shop.RecordShop.model.Album;
import com.northcoders.record_shop.RecordShop.repository.RecordRepository;
import com.northcoders.record_shop.RecordShop.util.FieldUpdater;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecordShopServiceImpl implements RecordShopService {

    @Autowired
    private RecordRepository recordRepo;

    @Override
    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();

        for (Album a: this.recordRepo.findAll()) {
            albums.add(a);
        }

        return albums;
    }

    @Override
    public Album addAlbum(Album album) {
        this.recordRepo.save(album);
        return null;
    }

    @Override
    public Album getAlbumById(Long id) {
        Optional<Album> foundAlbum = this.recordRepo.findById(id);

        if (foundAlbum.isPresent())
            return foundAlbum.get();

        throw new AlbumNotFoundException(String.format("Album with ID %d not found.", id));
    }

    @Override
    public Album updateAlbum(Long id, Album album) {
        Optional<Album> foundAlbum = this.recordRepo.findById(id);

        if (foundAlbum.isEmpty())
            throw new AlbumNotFoundException("Couldn't find this album in the database. Try POSTing it before modifying it.");

        Album albumFromDb = foundAlbum.get();

        try {
            FieldUpdater.updateFieldsWhereNotNull(album, albumFromDb);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        this.recordRepo.save(albumFromDb);

        return albumFromDb;
    }

    @Override
    public List<Album> addAlbums(Album[] albums) {
        ArrayList<Album> addedAlbums = new ArrayList<>();

        for (Album a: albums) {
            addedAlbums.add(this.addAlbum(a));
        }

        return addedAlbums;
    }
}
