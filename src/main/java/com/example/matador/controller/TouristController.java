package com.example.matador.controller;

import com.example.matador.model.TouristAttraction;
import com.example.matador.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Controller
public class TouristController {

    private final TouristService service;
    public TouristController(TouristService service) {
        this.service = service;
    }


    @GetMapping("/attractions")
    public String getAllAttractions(Model model) {
        List<TouristAttraction> touristAttractions = service.getTouristAttractions();
        model.addAttribute("touristAttractions", touristAttractions);
        return "attractionList";
    }
}
