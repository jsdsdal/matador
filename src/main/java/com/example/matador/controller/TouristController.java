package com.example.matador.controller;

import com.example.matador.model.TouristAttraction;
import com.example.matador.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class TouristController {

    private final TouristService service;
    public TouristController(TouristService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<TouristAttraction>> getTouristAttractions() {
        List<TouristAttraction> touristAttractions = service.getTouristAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<TouristAttraction> getTouristAttractionByName(@PathVariable String name) {
        TouristAttraction touristAttraction = service.getTouristAttractionByName(name);
        if (touristAttraction==null) {
            return new ResponseEntity<>(touristAttraction, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
        }
    }

    @PostMapping("add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction addedTouristAttraction = service.addTouristAttraction(touristAttraction);
        return ResponseEntity.ok(touristAttraction);
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
