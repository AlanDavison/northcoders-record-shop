package com.northcoders.record_shop.RecordShop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.record_shop.RecordShop.model.Album;
import com.northcoders.record_shop.RecordShop.model.AlbumType;
import com.northcoders.record_shop.RecordShop.model.Artist;
import com.northcoders.record_shop.RecordShop.model.Genre;
import com.northcoders.record_shop.RecordShop.repository.RecordShopRepository;
import com.northcoders.record_shop.RecordShop.service.RecordShopServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
class RecordShopControllerTest {

    @Mock
    private RecordShopRepository repo;

    @InjectMocks
    private RecordShopController controller;

    @Mock
    private RecordShopServiceImpl service;

    @Autowired
    MockMvc mockMvc;

    private ObjectMapper mapper;
    List<Album> seedAlbums = new ArrayList<>();

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
        this.mapper = new ObjectMapper();
        this.seedAlbums = List.of(
                new Album(1L,
                        new Artist(1L, "Jethro Tull", "http://image.com", List.of()),
                        "Thick as a Brick",
                        "Thick as a brick!",
                        "http://image.com",
                        Genre.JETHROTULL, AlbumType.CD,
                        10L,
                        new BigDecimal(10.00)),
                new Album(2L,
                        new Artist(2L, "Pink Floyd", "http://image.com", List.of()),
                        "Dark Side of the Moon",
                        "Moon I guess?",
                        "http://image.com",
                        Genre.PROGROCK, AlbumType.CD,
                        14L,
                        new BigDecimal(12.00)),
                new Album(3L,
                        new Artist(3L, "Iron Maiden", "http://image.com", List.of()),
                        "Fear of the Dark",
                        "Spooky!",
                        "http://image.com",
                        Genre.METAL, AlbumType.CD,
                        20L,
                        new BigDecimal(8.00))
        );
    }

    @Test
    @DisplayName("Test getting all albums from our controller.")
    void getAllRecords() throws Exception {
        when(this.service.getAllAlbums()).thenReturn(this.seedAlbums);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/records/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Thick as a Brick"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Dark Side of the Moon"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].name").value("Fear of the Dark"));
    }

    @Test
    @DisplayName("Test getting a record by its ID.")
    void getRecordById() throws Exception {
        when(this.service.getAllAlbums()).thenReturn(this.seedAlbums);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/records/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Dark Side of the Moon"));
    }
}