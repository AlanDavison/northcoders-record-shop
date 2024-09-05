package com.northcoders.record_shop.RecordShop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.record_shop.RecordShop.service.RecordShopServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
    }

    @Test
    void getAllRecords() {
    }
}