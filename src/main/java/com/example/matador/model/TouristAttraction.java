package com.example.matador.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



@Entity
@Table(name = "attractions")
public class TouristAttraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="attraction_id")
    private long attractionId;

    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="location")
    private String location;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "attractionTags", joinColumns = @JoinColumn(name = "attraction_id"))
    @Column(name = "tag_id")
    private List<Tags> tags = new ArrayList<>();


//    private double price;

    public TouristAttraction(String name, String description, String location, List<Tags> tags){
        this.name = name;
        this.description = description;
        this.location = location;
        this.tags = tags;
    }

    public TouristAttraction() {}

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getLocation() { return  location; }
    public List<Tags> getTags() { return tags; }
    public long getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(long attractionId) {
        this.attractionId = attractionId;
    }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setLocation(String location) { this.location = location; }
    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public void addTags(Tags tag) { tags.add(tag); }
    public void removeTags(Tags tag) { tags.remove(tag);}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TouristAttraction that = (TouristAttraction) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(location, that.location) && Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, location, tags);
    }


    @Override
    public String toString() {
        return "Name: " + name + ", Description: " + description;
    }


}
