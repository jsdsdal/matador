package com.example.matador.controller;

import com.example.matador.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;


public class TouristController {

    private final TouristService service;

    public TouristController(TouristService service) {
        this.service = service;
    }

    @GetMapping("/{name}/tags")
    public String getTagsForTouristAttraction(Model model){
        model.addAttribute("tags", )

        return "tags";
    }



}
