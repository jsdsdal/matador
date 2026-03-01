package com.example.matador.controller;

import com.example.matador.model.Tags;
import com.example.matador.model.TouristAttraction;
import com.example.matador.service.TouristService;
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

    @GetMapping("/")
    public String home() {
        return "index";
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
        model.addAttribute("allTags",service.getTags());
        model.addAttribute("allLocations", service.getLocations());
        return "attraction-creation-form";
    }

    @PostMapping("/attractions/add")
    public String register(@ModelAttribute TouristAttraction touristAttraction) {
        service.addTouristAttraction(touristAttraction);
        return "redirect:/attractions";
    }

    @GetMapping("/attractions/{objectId}/tags")
    public String getTagsForTouristAttraction(@PathVariable int objectId, Model model) {
        TouristAttraction attraction = service.findById(objectId);
        List<Tags> userTags = attraction.getTags();
        model.addAttribute("attraction", attraction);
        model.addAttribute("tags", userTags);
        return "tags";
    }

    @PostMapping("/attractions/delete/{objectId}")
    public String delete(@PathVariable int objectId) {
        service.delete(objectId);
       return "redirect:/attractions";
    }

    @GetMapping("/attractions/getDelete/{objectId}")
    public String getDeleteByName(@PathVariable int objectId, Model model) {
        TouristAttraction touristAttraction = service.findById(objectId);
        model.addAttribute("attractionToDelete", touristAttraction);
        return "confirmDelete";
    }

    @GetMapping("/attractions/edit/{objectId}")
    public String getUpdateAttraction(@PathVariable int objectId, Model model) {
        TouristAttraction myAttraction = service.findById(objectId);
        model.addAttribute("attraction", myAttraction);
        model.addAttribute("allTags", service.getTags());
        return "updateAttraction";
    }

    @PostMapping("/attractions/edit/{name}")
    public String updateAttraction(@ModelAttribute TouristAttraction updatedTouristAttraction) {
        service.update(updatedTouristAttraction);
        return "redirect:/attractions";
    }
}

