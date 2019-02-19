package daw.itinerary;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import daw.itinerary.unit.*;
import daw.itinerary.itineraries.*;
import daw.itinerary.security.*;

@Component
public class DatabaseInitializer {

	// Here repositories from database
	@Autowired
	private UnitRepository unitRepo;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {

			unitRepo.save(new Unit("Año 1989"));
			unitRepo.save(new Unit("CERN"));
			unitRepo.save(new Unit("Tim Berners Lee"));
			unitRepo.save(new Unit("JavaScript"));
	}

}
