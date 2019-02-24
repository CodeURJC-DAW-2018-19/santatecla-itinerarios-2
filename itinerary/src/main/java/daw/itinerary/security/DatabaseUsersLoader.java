package daw.itinerary.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import daw.itinerary.user.User;
import daw.itinerary.user.UserRepository;

@Component
public class DatabaseUsersLoader {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	private void initDatabase() {

		userRepository.save(new User("estudiante1", "pass", "ROLE_USER"));
		userRepository.save(new User("estudiante2", "pass2", "ROLE_USER"));

		userRepository.save(new User("profesor", "passprofe", "ROLE_USER", "ROLE_ADMIN"));
	}

}
