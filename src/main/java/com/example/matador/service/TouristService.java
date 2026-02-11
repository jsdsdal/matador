package com.example.matador.service;

import com.example.matador.model.TouristAttraction;
import com.example.matador.repository.TouristRepository;

import java.util.List;

public class TouristService {

    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public List<TouristAttraction> getTouristAttractions(){
        return repository.getTouristAttractions();

    }

    public TouristAttraction getTouristAttractionByName(String name) {
        return repository.getTouristAttractionByName(name);
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction){
        return repository.addTouristAttraction(touristAttraction);
    }



    public TouristAttraction updateTouristAttractionName(TouristAttraction touristAttraction, String name) {
        repository.updateTouristAttractionName(touristAttraction, name);
        return touristAttraction;
    }

    public TouristAttraction updateTouristAttractionDescription(TouristAttraction touristAttraction, String description) {
        repository.updateTouristAttractionDescription(touristAttraction, description);
        return touristAttraction;
    }

    public TouristAttraction deleteByName(String name){
        return repository.deleteByName(name);
    }


}
