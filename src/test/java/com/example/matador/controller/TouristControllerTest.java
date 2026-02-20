package com.example.matador.controller;

import com.example.matador.model.Tags;
import com.example.matador.model.TouristAttraction;
import com.example.matador.repository.TouristRepository;
import com.example.matador.service.TouristService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
                .andExpect(view().name("updateAttraction"))
                .andExpect(model().attributeExists("attraction"))
                .andExpect(model().attributeExists("allTags"));

        verify(service).getTouristAttractionByName("Tivoli");
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

    void ShouldRegisterNewAttraction() throws Exception {
        TouristAttraction touristAttraction = new TouristAttraction("Hvidovrevej", "Et godt sted at starte", "Nørrebro", List.of(Tags.BØRNEVENLIG, Tags.KULTUR));
        when(service.addTouristAttraction(any(TouristAttraction.class))).thenReturn(touristAttraction);

        mockMvc.perform(post("/attractions/add")
                .param("name", "Hvidovrevej")
                .param("description", "Et godt sted at starte")
                .param("location", "Nørrebro")
                .param("tags", "BØRNEVENLIG")
                .param("tags", "KULTUR"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/attractions"));

        ArgumentCaptor<TouristAttraction> captor = ArgumentCaptor.forClass((TouristAttraction.class));
        verify(service).addTouristAttraction(captor.capture());

        TouristAttraction captured = captor.getValue();
        assertEquals("Hvidovrevej", captured.getName());
        assertEquals("Et godt sted at starte", captured.getDescription());
        assertEquals("Nørrebro", captured.getLocation());
        assertNotNull(captured.getTags());

    }

    @Test
    void ShouldRegisterNewAttractionButWrongAsserts() throws Exception {
        TouristAttraction touristAttraction = new TouristAttraction("Hvidovrevej", "Et godt sted at starte", "Nørrebro", List.of(Tags.BØRNEVENLIG, Tags.KULTUR));
        when(service.addTouristAttraction(any(TouristAttraction.class))).thenReturn(touristAttraction);

        mockMvc.perform(post("/attractions/add")
                        .param("name", "Hvidovrevej")
                        .param("description", "Et godt sted at starte")
                        .param("location", "Nørrebro")
                        .param("tags", "BØRNEVENLIG")
                        .param("tags", "KULTUR"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/attractions"));

        ArgumentCaptor<TouristAttraction> captor = ArgumentCaptor.forClass((TouristAttraction.class));
        verify(service).addTouristAttraction(captor.capture());

        TouristAttraction captured = captor.getValue();
        assertNotEquals("", captured.getName());
        assertNotEquals("Et sted at starte", captured.getDescription());
        assertNotEquals("", captured.getLocation());

    }

    @Test
    void register() {
    }



    @Test
    void ShouldDeleteByName() {
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