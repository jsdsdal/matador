package com.example.matador.repository;

import com.example.matador.model.Tags;
import com.example.matador.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TouristRepository {

    private final List<TouristAttraction> touristAttractions = new ArrayList<>();

    /**
     * Tilføjer hardcoded turist attraktioner for test
     */
    public void populateTouristAttractions() {
        touristAttractions.add(new TouristAttraction("Tivoli", "Forlystelsespark", "Nørrebrø", List.of()));
        touristAttractions.add(new TouristAttraction("Den Lille Havfrue", "Seværdighed", "Nørrebrø", List.of()));
        touristAttractions.add(new TouristAttraction("Rundetårn", "Kulturarv", "Nørrebrø", List.of()));
    }

    public TouristRepository() {
        populateTouristAttractions();
    }

    // getter
    public List<TouristAttraction> getTouristAttractions() { return touristAttractions; }

    // getter til navn
    public TouristAttraction getTouristAttractionByName(String name) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    // tilføjer turistattraktion
    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) { touristAttractions.add(touristAttraction); return touristAttraction; }

    // opdaterer kun navn
    public void updateTouristAttractionName (TouristAttraction touristAttraction, String name) {
        if (name != null) {
            touristAttraction.setName(name);
        }
    }

    // opdaterer beskrivelse
    public void updateTouristAttractionDescription (TouristAttraction touristAttraction, String description) {
        if (description != null) {
            touristAttraction.setName(description);
        }
    }

    // generic remove
    public void removeTouristAttraction(TouristAttraction touristAttraction) { touristAttractions.remove(touristAttraction); }

    // remove by name
    public TouristAttraction deleteByName(String name) {
        TouristAttraction deletedAttraction = touristAttractions.get(0);

        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName() == name) {
                deletedAttraction = touristAttraction;
            }
        }
        removeTouristAttraction(deletedAttraction);
        return deletedAttraction;
    }


    /**
     * Denne metoder opretter et TreeSet med
     * alle vores nuværende lokationer i touristAttractions
     * listen.
     * @return <b>Locations</b>
     */
    public Set<String> getLocations() {
        Set<String> locations = new TreeSet<>();
        for (TouristAttraction element : touristAttractions) {
            var locationItem = element.getLocation();
            locations.add(locationItem);
        }
        return locations;
    }

    /**
     * Opretter en liste af vores eksisterende Tags
     * og returnerer dem
     * @return allEnums
     */
    public List<Tags> getTags() {
        List<Tags> allEnums = new ArrayList<>(EnumSet.allOf(Tags.class));
        return allEnums;
    }
}
