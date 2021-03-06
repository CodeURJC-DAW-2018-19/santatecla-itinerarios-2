package daw.itinerary.unit;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import daw.itinerary.itineraries.*;
import daw.itinerary.content.*;

@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String name;

    public Unit(){}

    public Unit(String name) {
    	this.name = name;
    }
    
    public Unit(long id, String name){
        this.id = id;
    	this.name = name;
    }

    public String getName(){
        return name;
    }
    
    
    public void setName(String name) {
		this.name = name;
	}

	public void setItineraries(Set<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}

	public void setContents(Set<Content> contents) {
		this.contents = contents;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void addItinerary(Itinerary itinerary) {
        if (this.itineraries == null) {
            this.itineraries = new HashSet<>();
        }
        this.itineraries.add(itinerary);
    }

    public void addContent(Content content) {
        if (this.contents == null) {
            this.contents = new HashSet<>();
        }
        this.contents.add(content);
    }
    
    public Set<Content> getContents() {
		return contents;
	}

    public Set<Itinerary> getItineraries()
    {
        return itineraries;
    }

    @Override
   	public String toString() {
   		return "Content [id=" + id + ", name=" + name + "]";
   	}
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unit")
    private Set<Itinerary> itineraries;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unit")
    private Set<Content> contents;

}