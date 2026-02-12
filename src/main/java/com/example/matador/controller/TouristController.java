package com.example.matador.controller;

import com.example.matador.model.Tags;
import com.example.matador.model.TouristAttraction;
import com.example.matador.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/attractions/add")
    public String showTouristAttractionCreationForm(Model model){
        TouristAttraction touristAttraction = new TouristAttraction();
        model.addAttribute("TouristAttraction", touristAttraction);
        model.addAttribute("tags", Tags.values());
        return "attraction-creation-form";
    }

    @PostMapping("/attractions/add")
    public String register(@ModelAttribute TouristAttraction touristAttraction) {
        service.addTouristAttraction(touristAttraction);
        return "redirect:/attractions";
    }

    @PostMapping("{name}")
    public ResponseEntity<TouristAttraction> deleteByName(@PathVariable String name) {
        TouristAttraction touristAttraction = service.deleteByName(name);
        if (touristAttraction==null) {
            return new ResponseEntity<>(touristAttraction, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
        }
    }
}
