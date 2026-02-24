package com.example.matador.model;

import java.util.*;

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

    public Map<String, String> getTouristAttractionLocations() {
        return Collections.unmodifiableMap(touristAttractionLocations);
    }

    public List<String> getTouristAttractionTags() {
        return Collections.unmodifiableList(touristAttractionTags);
    }

}
