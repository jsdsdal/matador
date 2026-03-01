package com.example.matador.service;

import com.example.matador.model.Tags;
import com.example.matador.model.TouristAttraction;
import com.example.matador.repository.TouristRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public TouristAttraction findById(int objectId) {
        return repository.findById(objectId).orElse(null);
    }

    @Transactional
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

    @Transactional
    public void delete(int objectId){
        repository.deleteById(objectId);
    }

    @Transactional
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
