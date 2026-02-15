package com.example.matador.controller;

import com.example.matador.model.TouristAttraction;
import com.example.matador.service.TouristService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

class TouristControllerTest {


    @Autowired
    MockMvc mockMvc;
    @MockitoBean
    TouristService


    @Test
    void getAllAttractions() {
        MockMvc
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