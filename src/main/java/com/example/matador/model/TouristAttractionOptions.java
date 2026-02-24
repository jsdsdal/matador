package com.example.matador.model;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TouristAttractionOptions {
    private Map<String, String> touristAttractionLocations;
    private List<String> touristAttractionTags;

    public TouristAttractionOptions() {
        this.touristAttractionLocations = new HashMap<>(
                Map.of("Hvidovrevej", "#0020FF",
                        "Rødovrevej", "#0050FF",
                        "Trianglen", "#0050FF"
        ));
        this.touristAttractionTags = new ArrayList<>(
            List.of("Børnevenlig", "Handicapvenlig", "Gratis",
                    "Udendørs", "Indendørs"
        ));
    }

    public Map<String, String> getTouristAttractionLocationsAsMap() {
        return Collections.unmodifiableMap(touristAttractionLocations);
    }

    public List<String> getTouristAttractionLocations() {
        return new ArrayList<>(touristAttractionLocations.keySet());
    }

    public List<String> getTouristAttractionTags() {
        return Collections.unmodifiableList(touristAttractionTags);
    }

    public String getHexColorByLocation(String location) {
        return touristAttractionLocations.get(location);
    }

}
