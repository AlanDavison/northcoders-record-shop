package com.northcoders.record_shop.RecordShop.controller;

import com.northcoders.record_shop.RecordShop.model.Album;
import com.northcoders.record_shop.RecordShop.model.Artist;
import com.northcoders.record_shop.RecordShop.service.RecordShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recordshop")
public class RecordShopController {

    @Autowired
    RecordShopService service;

    @GetMapping("/records")
    public ResponseEntity<List<Album>> getAllRecords() {
        return new ResponseEntity<>(this.service.getAllAlbums(), HttpStatus.OK);
    }

    @GetMapping("/records/{recordId}")
    public ResponseEntity<Album> getRecordById(@PathVariable Long recordId) {
        return new ResponseEntity<>(this.service.getAlbumById(recordId), HttpStatus.OK);
    }

    @PatchMapping("/records/{recordId}")
    public ResponseEntity<Album> patchRecordById(@PathVariable Long recordId, @RequestBody Album album) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.updateAlbum(recordId, album));
    }

    @PostMapping("/records")
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        return new ResponseEntity<>(this.service.addAlbum(album), HttpStatus.CREATED);
    }

    @PostMapping("/records/many")
    public ResponseEntity<List<Album>> addManyAlbums(@RequestBody Album[] albums) {
        return new ResponseEntity<>(this.service.addAlbums(albums), HttpStatus.CREATED);
    }

    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getArtists() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.getAllArtists());
    }

    @GetMapping("/artists/{artistId}")
    public ResponseEntity<Artist> getArtistById(@PathVariable String artistId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.getArtistById(artistId));
    }

    @PostMapping("/artists")
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.addArtist(artist));
    }

    @PostMapping("/artists/many")
    public ResponseEntity<List<Artist>> addManyArtists(@RequestBody Artist[] artists) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.addArtists(artists));
    }
}
