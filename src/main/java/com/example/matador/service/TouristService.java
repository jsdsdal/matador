package com.example.matador.service;

import com.example.matador.model.Tags;
import com.example.matador.model.TouristAttraction;
import com.example.matador.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TouristService {

    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public List<TouristAttraction> getTouristAttractions(){
        return repository.findAll();

    }

    public TouristAttraction getTouristAttractionByName(String name) {
        return repository.findByNameIgnoreCase(name).orElse(null);
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction){
        return repository.save(touristAttraction);
    }


    public TouristAttraction updateTouristAttractionName(TouristAttraction touristAttraction, String name) {
        touristAttraction.setName(name);
        return repository.save(touristAttraction);
    }

    public TouristAttraction updateTouristAttractionDescription(TouristAttraction touristAttraction, String description) {
        touristAttraction.setDescription(description);
        return repository.save(touristAttraction);

    }


    public void deleteByName(String name){
        repository.deleteByNameIgnoreCase(name);
    }


    public void update(TouristAttraction updatedTouristAttraction) {
        repository.save(updatedTouristAttraction);
    }

    /**
     * Opretter en liste af vores eksisterende Tags
     * og returnerer dem
     * @return allEnums
     */
    public List<Tags> getTags() {
        List<Tags> allEnums;
        allEnums = new ArrayList<>(EnumSet.allOf(Tags.class));
        return allEnums;
    }


    public Set<String> getLocations() {
        return repository.findAll().stream().map(TouristAttraction::getLocation).collect(Collectors.toCollection(TreeSet::new));
    }



}
