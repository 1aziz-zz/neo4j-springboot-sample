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

public class Patient {
    @GraphId
    private Long id;
    private String name, gender;
    private int age;
    private double height, weight;
    @Relationship(type = "knows", direction = Relationship.UNDIRECTED)
    private Set<Patient> connection;

    @Relationship(type = "diagnosed_with", direction = Relationship.UNDIRECTED)
    private Set<Disease> diseases;


    public Patient(String name, int age, String gender, double height, double weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.diseases = new HashSet<>();
        this.connection = new HashSet<>();

    }


    @Relationship(type = "follows", direction = Relationship.UNDIRECTED)
    private Treatment treatment;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void knows(Patient patient) {
        if (connection == null) {
            connection = new HashSet<>();
        }
        connection.add(patient);
    }

    public void isDiagnosedWith(Disease desease) {
        if (diseases == null) {
            diseases = new HashSet<>();
        }
        diseases.add(desease);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public Set<Patient> getConnection() {
        return connection;
    }

    public Set<Disease> getDiseases() {
        return diseases;
    }
}
