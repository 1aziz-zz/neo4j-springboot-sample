package sample.model;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aziz on 23-3-17 :)
 */
@NodeEntity

public class Disease {
    @GraphId
    private Long id;

    private String name, description;

    @Relationship(type = "has_a", direction = Relationship.UNDIRECTED)
    private Set<Treatment> treatments;

    public Disease(String name, String description) {
        this.name = name;
        this.description = description;
        this.treatments = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Set<Treatment> getTreatments() {
        return treatments;
    }

    public void addTreatment(Treatment treatment) {
        this.getTreatments().add(treatment);
    }
}
