package daw.itinerary.itineraries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
