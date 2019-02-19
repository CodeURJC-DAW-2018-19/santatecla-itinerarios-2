package daw.itinerary.itineraries;

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
