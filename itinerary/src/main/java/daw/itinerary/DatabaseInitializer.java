package daw.itinerary;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import daw.itinerary.unit.*;
import daw.itinerary.user.UserRepository;
import daw.itinerary.user.User;
import daw.itinerary.content.Content;
import daw.itinerary.content.ContentRepository;
import daw.itinerary.itineraries.*;

@Component
public class DatabaseInitializer {

	// Here repositories from database
	@Autowired
	private UnitRepository unitRepo;
	
	@Autowired
	private ContentRepository contentRepo;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItineraryRepository itineraryRepo;

	@PostConstruct
	public void init() {
			Content exampleContent = new Content("¿Para qué?","lus semper vitae. Sed auctor placerat viverra. Ut a tellus vitae sapien pellentesque elementu");
			Unit unit1 = new Unit(1, "Javascript");
			Unit unit3 = new Unit(3, "CERN");
			Unit unit4 = new Unit(4, "Tim Berners Lee");
			Unit unit5 = new Unit(5, "Año 1989");
			/*Itinerary and Unit sample initializer */

			unit1.addContent(exampleContent);
			unitRepo.save(unit1);
			unitRepo.save(unit3);
			unitRepo.save(unit4);
			unitRepo.save(unit5);
			
			itineraryRepo.save(new Itinerary("Primeros pasos", unit1));
			itineraryRepo.save(new Itinerary("Uso avanzado", unit1));
			itineraryRepo.save(new Itinerary("Eventos", unit5));
			itineraryRepo.save(new Itinerary("Cumpleaños de famosos", unit5));
			itineraryRepo.save(new Itinerary("Calendario", unit5));
			itineraryRepo.save(new Itinerary("Historia", unit3));
			itineraryRepo.save(new Itinerary("Principales líneas de investigación", unit3));
			itineraryRepo.save(new Itinerary("Futuros proyectos", unit3));
			itineraryRepo.save(new Itinerary("Datos adicionales", unit3));
			itineraryRepo.save(new Itinerary("Biografía", unit4));
			itineraryRepo.save(new Itinerary("World Wide Web", unit4));
			
			/*Content sample initializer */
			contentRepo.save(exampleContent);
			contentRepo.save(new Content("¿Por qué?",". Pellentesque vitae sapien magna. Ut id ullamcorper elit. Fusce feugiat, sem at euismod placerat, mauris ex mattis"));
			contentRepo.save(new Content("¿Cómo?","massa. Quisque ornare ipsum id ligula tincidunt, condimentum porta mus, augue lectus ultrices velit, in tincidunt purus nunc sit amet lacus"));
			
			/*User samples*/
			userRepository.save(new User("alumno1", "pass1", "ROLE_USER"));
			userRepository.save(new User("alumno2", "pass2", "ROLE_USER"));
			userRepository.save(new User("profesor", "passprofe", "ROLE_USER", "ROLE_ADMIN"));
	}

}
