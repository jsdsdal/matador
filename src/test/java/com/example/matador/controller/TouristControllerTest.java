package com.example.matador.controller;

import com.example.matador.service.TouristService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TouristController.class)
class TouristControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockitoBean
    TouristService service;


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
    void getDeleteByName() {
    }

    @Test
    void getUpdateAttraction() {
    }

    @Test
    void updateAttraction() {
    }
}