package daw.itinerary.itineraries;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class ItineraryController {

    @Autowired
    private ItineraryRepository repository;

    @PostConstruct
    public void init() {
        repository.save(new Itinerary("Resumen"));
        repository.save(new Itinerary("Introducción"));
        repository.save(new Itinerary("Biografía"));
        repository.save(new Itinerary("Contexto"));
    }
}
