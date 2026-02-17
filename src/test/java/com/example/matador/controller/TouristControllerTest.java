package com.example.matador.controller;

import com.example.matador.model.Tags;
import com.example.matador.model.TouristAttraction;
import com.example.matador.repository.TouristRepository;
import com.example.matador.service.TouristService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
    void getUpdateAttraction() throws Exception {

        TouristAttraction attraction = new TouristAttraction();
        List<Tags> tags = List.of(Tags.GRATIS, Tags.KULTUR);

        when(service.getTouristAttractionByName("Tivoli")).thenReturn(attraction);
        when(service.getTags()).thenReturn(tags);

        mockMvc.perform(get("/attractions/edit/Tivoli"))
                .andExpect(status().isOk())
                .andExpect(view().name("updateAttraction"))
                .andExpect(model().attributeExists("attraction"))
                .andExpect(model().attributeExists("allTags"));

        verify(service).getTouristAttractionByName("Tivoli");
        verify(service).getTags();
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
    void updateAttraction() throws Exception {

        mockMvc.perform(post("/attractions/edit/Tivoli")
                        .param("name", "Tivoli")
                        .param("description", "Forlystelsespark")
                        .param("location", "Nørrebrø"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/attractions"));

        verify(service).update(org.mockito.ArgumentMatchers.any(TouristAttraction.class));
    }

}