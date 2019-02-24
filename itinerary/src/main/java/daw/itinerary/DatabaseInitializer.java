package daw.itinerary;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import daw.itinerary.unit.*;
import daw.itinerary.user.UserRepository;
import daw.itinerary.user.User;
import daw.itinerary.content.Content;
import daw.itinerary.content.ContentRepository;

@Component
public class DatabaseInitializer {

	// Here repositories from database
	@Autowired
	private UnitRepository unitRepo;
	
	@Autowired
	private ContentRepository contentRepo;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {
			Content exampleContent = new Content("¿Para qué?","lus semper vitae. Sed auctor placerat viverra. Ut a tellus vitae sapien pellentesque elementu");
			Unit exampleUnit = new Unit("Javascript");
			
			exampleUnit.addContent(exampleContent);
			unitRepo.save(new Unit("Año 1989"));
			unitRepo.save(new Unit("CERN"));
			unitRepo.save(new Unit("Tim Berners Lee"));
			unitRepo.save(exampleUnit);
			
			
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
