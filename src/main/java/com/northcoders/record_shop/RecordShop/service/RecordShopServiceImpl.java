package com.northcoders.record_shop.RecordShop.service;

import com.northcoders.record_shop.RecordShop.exception.AlbumNotFoundException;
import com.northcoders.record_shop.RecordShop.exception.ArtistNotFoundException;
import com.northcoders.record_shop.RecordShop.model.Album;
import com.northcoders.record_shop.RecordShop.model.Artist;
import com.northcoders.record_shop.RecordShop.repository.ArtistRepository;
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

    @Autowired
    private ArtistRepository artistRepo;

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
        if (album.getArtists().isEmpty())
            throw new ArtistNotFoundException("Your album needs to have an artist.");

        for (Artist a: album.getArtists()) {
            if (!this.artistRepo.existsById(a.getName())) {
                a.getAlbums().add(album);
                this.artistRepo.save(a);
            }
        }

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
    public List<Artist> getAllArtists() {
        List<Artist> foundArtists = new ArrayList<>();

        for (Artist a: this.artistRepo.findAll())
            foundArtists.add(this.artistRepo.findById(a.getName()).get());

        if (foundArtists.isEmpty())
            throw new ArtistNotFoundException("No artists found in the database.");

        return foundArtists;
    }

    @Override
    public Artist addArtist(Artist artist) {
        return this.artistRepo.save(artist);
    }

    @Override
    public Artist getArtistById(String id) {
        Optional<Artist> foundArtist = this.artistRepo.findById(id);

        if (foundArtist.isEmpty())
            throw new ArtistNotFoundException(String.format("Artist with ID %d not found.", id));

        return foundArtist.get();
    }

    @Override
    public Artist updateArtistById(String id, Artist artist) {
        return null;
    }

    @Override
    public List<Album> addAlbums(Album[] albums) {
        ArrayList<Album> addedAlbums = new ArrayList<>();

        for (Album a: albums) {
            addedAlbums.add(this.addAlbum(a));
        }

        return addedAlbums;
    }

    @Override
    public List<Artist> addArtists(Artist[] artists) {
        ArrayList<Artist> addedArtists = new ArrayList<>();

        for (Artist a: artists) {
            addedArtists.add(this.addArtist(a));
        }

        return addedArtists;
    }
}
