package com.example.matador.repository;

import com.example.matador.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

public class TouristRepository {

    private final List<TouristAttraction> touristAttractions = new ArrayList<>();

    // tilføjer alle attraktioner til listen
    public void populateTouristAttractions() {
        touristAttractions.add(new TouristAttraction("Tivoli", "Forlystelsespark", "Nørrebrø", List.of()));
        touristAttractions.add(new TouristAttraction("Den Lille Havfrue", "Seværdighed", "Nørrebrø", List.of()));
        touristAttractions.add(new TouristAttraction("Rundetårn", "Kulturarv", "Nørrebrø", List.of()));
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

    // hent locations fra hardkodet liste i repository
    public List<String> getLocations() {
        return null;
    }

    // hent tags hardkodet liste i repository
    public List<String> getTags() {
        return null;

    }
}
