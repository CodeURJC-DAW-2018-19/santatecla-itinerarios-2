package daw.itinerary.content;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import daw.itinerary.unit.Unit;

@Entity
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String title;
    private String desc;
    private String image;

    public Content(){}

    public Content(String title){
        super();
    	this.title = title;
    }	
    
    public Content(String title, String desc){
        super();
    	this.title = title;
        this.desc = desc;
    }

    public Content(String title, String desc, Unit unit){
        super();
        this.title = title;
        this.desc = desc;
        this.unit = unit;
    }

    public String getTitle(){
        return title;
    }
    
    public String getDesc(){
    	return desc;
        }
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public void setDesc(String desc) {
    	this.desc = desc;
    }
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	@JsonIgnore
	@ManyToOne
    private Unit unit;
    
    @Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", description=" + desc + ", unit=" + unit + "]";
	}
    
}