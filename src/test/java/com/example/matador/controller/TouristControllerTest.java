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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
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
    void showTouristAttractionCreationForm() throws Exception {
        List<Tags> tags = new ArrayList<>();

        when(service.getTags()).thenReturn(tags);

        mockMvc.perform(get("/attractions/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("attraction-creation-form"))
                .andExpect(model().attribute("TouristAttraction", new TouristAttraction()))
                .andExpect(model().attributeExists("TouristAttraction"))
                .andExpect(model().attributeExists("allTags"))
                .andExpect(model().attribute("allTags", tags))
                .andExpect(model().attributeExists("allLocations"));
        verify(service).getTags();

    }

    @Test
    void getTagsForTouristAttraction() throws Exception{

        TouristAttraction tivoli = new TouristAttraction("Tivoli", "Forlystelsespark",
                "Nørrebrø", List.of(Tags.BØRNEVENLIG, Tags.GRATIS));

        when(service.getTouristAttractionByName("Tivoli")).thenReturn(tivoli);

        mockMvc.perform(get("/Tivoli/tags"))
                .andExpect(status().isOk())
                .andExpect(view().name("tags"))
                .andExpect(model().attributeExists("tags"))
                .andExpect(model().attributeExists("name"))
                .andExpect(model().attribute("name", "Tivoli"))
                .andExpect(model().attribute("tags", hasSize(2)))
                .andExpect(model().attribute("tags",
                        List.of(Tags.BØRNEVENLIG, Tags.GRATIS)));
                verify(service).getTouristAttractionByName("Tivoli");


    }

    @Test
    void register() {
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