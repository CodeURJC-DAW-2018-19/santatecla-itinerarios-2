package daw.itinerary.content;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import daw.itinerary.unit.Unit;

@Entity
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String title;
    private String desc;

    public Content(){}

   /* public Content(String title){
        super();
    	this.title = title;
    }	*/
    
    public Content(String title, String desc){
        super();
    	this.title = title;
        this.desc = desc;
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
    
    @ManyToOne
    private Unit unit;
    
    @Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", description=" + desc + ", unit=" + unit + "]";
	}
    
}