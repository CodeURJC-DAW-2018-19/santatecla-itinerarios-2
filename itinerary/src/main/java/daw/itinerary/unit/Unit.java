package daw.itinerary.unit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String name;

    public Unit(){}

    public Unit(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    
    @Override
   	public String toString() {
   		return "Content [id=" + id + ", name=" + name + "]";
   	}
    

}