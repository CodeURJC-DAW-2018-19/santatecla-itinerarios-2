package daw.itinerary;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import daw.itinerary.unit.*;
import daw.itinerary.user.User;
import daw.itinerary.user.UserRepository;
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

		unitRepo.save(new Unit("Año 1989"));
		unitRepo.save(new Unit("CERN"));
		unitRepo.save(new Unit("Tim Berners Lee"));
		unitRepo.save(new Unit("JavaScript"));

		/* Content sample initializer */
		contentRepo.save(new Content("¿Para qué?",
				"lus semper vitae. Sed auctor placerat viverra. Ut a tellus vitae sapien pellentesque elementu"));
		contentRepo.save(new Content("¿Por qué?",
				". Pellentesque vitae sapien magna. Ut id ullamcorper elit. Fusce feugiat, sem at euismod placerat, mauris ex mattis"));
		contentRepo.save(new Content("¿Cómo?",
				"massa. Quisque ornare ipsum id ligula tincidunt, condimentum porta mus, augue lectus ultrices velit, in tincidunt purus nunc sit amet lacus"));

		// Sample users
		userRepository.save(new User("estudiante1", "pass", "ROLE_USER"));
		userRepository.save(new User("estudiante2", "pass2", "ROLE_USER"));

		userRepository.save(new User("profesor", "passprofe", "ROLE_USER", "ROLE_ADMIN"));

	}

}
