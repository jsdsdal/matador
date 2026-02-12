package com.example.matador.controller;

import com.example.matador.model.Tags;
import com.example.matador.model.TouristAttraction;
import com.example.matador.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

public class TouristController {

    private final TouristService service;

    public TouristController(TouristService service) {
        this.service = service;
    }

    @GetMapping("/{name}/tags")
    public String getTagsForTouristAttraction(Model model, String name){

        TouristAttraction attraction = service.getTouristAttractionByName(name);
        List<Tags> userTags = attraction.getTags();
        model.addAttribute("tags", userTags);

        return "tags";
    }



}
