package daw.itinerary.itineraries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import daw.itinerary.unit.Unit;

@Entity
public class Itinerary {

    /**********************************************
     * Fields
     *********************************************/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;


    /**********************************************
     * Constructors
     *********************************************/
    public Itinerary(){}

    public Itinerary(String name, Unit unit){
        this.setName(name);
        this.unit = unit;
    }

    /**********************************************
     * Methods
     *********************************************/
    @Override
    public String toString(){
        return null;
    }

    /**********************************************
     * Getters and setters
     *********************************************/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit()
    {
        return unit;
    }

    public void setUnit(Unit unit)
    {
        this.unit = unit;
    }

    @JsonIgnore
    @ManyToOne
    private Unit unit;
}
