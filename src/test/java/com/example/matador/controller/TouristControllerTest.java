package com.example.matador.controller;

import com.example.matador.repository.TouristRepository;
import com.example.matador.service.TouristService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TouristController.class)
class TouristControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    TouristRepository repository;

    @MockitoBean
    TouristService service;



    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllAttractions() throws Exception {
        mockMvc.perform(get("/attractions"))
                .andExpect(status().isOk())
                .andExpect(view().name("attractionList"));
    }

    @Test
    void showTouristAttractionCreationForm() {
    }

    @Test
    void register() {
    }

    @Test
    void getTagsForTouristAttraction() {
    }

    @Test
    void deleteByName() {
    }

    @Test
    void getUpdateAttraction() {
    }

    @Test
    void updateAttraction() {
    }
}