package com.northcoders.record_shop.RecordShop.controller;

import com.northcoders.record_shop.RecordShop.model.Album;
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

    @GetMapping
    public ResponseEntity<List<Album>> getAllRecords() {
        return new ResponseEntity<>(this.service.getAllAlbums(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        return new ResponseEntity<>(this.service.addAlbum(album), HttpStatus.CREATED);
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<Album> getRecordById(@PathVariable Long recordId) {
        return new ResponseEntity<>(this.service.getAlbumById(recordId), HttpStatus.OK);
    }
}
