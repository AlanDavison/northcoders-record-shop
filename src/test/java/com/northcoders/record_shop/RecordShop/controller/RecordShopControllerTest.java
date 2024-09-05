package com.northcoders.record_shop.RecordShop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.record_shop.RecordShop.model.Album;
import com.northcoders.record_shop.RecordShop.model.AlbumType;
import com.northcoders.record_shop.RecordShop.model.Artist;
import com.northcoders.record_shop.RecordShop.model.Genre;
import com.northcoders.record_shop.RecordShop.service.RecordShopServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
class RecordShopControllerTest {

    @Mock
    private RecordShopController controller;

    @Mock
    private RecordShopServiceImpl service;

    @Autowired
    MockMvc mockMvc;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
        this.mapper = new ObjectMapper();
        List<Album> albums = List.of(
                new Album(1L,
                        new Artist(1L, "Jethro Tull", "http://image.com", List.of()),
                        "Thick as a Brick",
                        "Thick as a brick!",
                        "http://image.com",
                        Genre.JETHROTULL, AlbumType.CD,
                        10L,
                        new BigDecimal(10.00)),
                new Album(1L,
                        new Artist(2L, "Pink Floyd", "http://image.com", List.of()),
                        "Dark Side of the Moon",
                        "Moon I guess?",
                        "http://image.com",
                        Genre.PROGROCK, AlbumType.CD,
                        14L,
                        new BigDecimal(12.00)),
                new Album(1L,
                        new Artist(3L, "Iron Maiden", "http://image.com", List.of()),
                        "Fear of the Dark",
                        "Spooky!",
                        "http://image.com",
                        Genre.METAL, AlbumType.CD,
                        20L,
                        new BigDecimal(8.00))
        );

        for (Album a: albums) {
            this.service.addAlbum(a);
        }
    }

    @Test
    @DisplayName("Test getting all albums from our controller.")
    void getAllRecords() {
    }
}