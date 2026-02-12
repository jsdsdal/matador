package com.example.matador.controller;

import com.example.matador.model.Tags;
import com.example.matador.model.TouristAttraction;
import com.example.matador.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
        model.addAttribute("allTags",Tags.values());
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

    @GetMapping("/{name}/edit")
    public String getUpdateAttraction(@PathVariable("name") String attraction, Model model) {
        TouristAttraction myAttraction = service.getTouristAttractionByName(attraction);
        model.addAttribute("attraction", myAttraction);
        return "updateAttraction";
    }

    @PostMapping("/{name}/edit")
    public String updateAttraction(@PathVariable("name") String name, @ModelAttribute TouristAttraction updatedTouristAttraction) {
        var description = updatedTouristAttraction.getDescription();
        service.updateTouristAttractionDescription(updatedTouristAttraction, description);
//        String description = myAttraction.getDescription();
//        String location = myAttraction.getLocation();
//        List<Tags> tags = myAttraction.getTags();
//        for (TouristAttraction element : service.getTouristAttractions()) {
//            if (element.getName().equalsIgnoreCase(myAttraction.getName())) {
//                element.setDescription(description);
//                element.setLocation(location);
//                element.setTags(tags);
//            }
//        }
        return "redirect:/attractions";
    }
}

