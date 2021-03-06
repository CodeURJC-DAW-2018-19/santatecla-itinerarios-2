package daw.itinerary.content;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Lob;
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
    private boolean hasImage;

    @Lob
    private byte[] imageRaw;
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

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public byte[] getImageRaw() {
		return imageRaw;
	}

	public void setImageRaw(byte[] imageRaw) {
		this.imageRaw = imageRaw;
	}

	public boolean isHasImage() {
		return hasImage;
	}

	public void setHasImage(boolean hasImage) {
		this.hasImage = hasImage;
	}

	@JsonIgnore
	@ManyToOne
    private Unit unit;
    
    @Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", description=" + desc + ", unit=" + unit + "]";
	}
    
}