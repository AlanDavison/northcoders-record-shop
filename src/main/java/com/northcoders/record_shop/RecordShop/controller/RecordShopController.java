package com.northcoders.record_shop.RecordShop.controller;

import com.northcoders.record_shop.RecordShop.model.Album;
import com.northcoders.record_shop.RecordShop.service.RecordShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/records")
public class RecordShopController {

    @Autowired
    RecordShopService service;

    @GetMapping("/all")
    public ResponseEntity<List<Album>> getAllRecords() {
        return this.service.getAllAlbums();
    }
}
