package daw.itinerary.api;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import daw.itinerary.user.User;
import daw.itinerary.user.UserComponent;

@RestController
public class LoginRestController {

	private static final Logger log = LoggerFactory.getLogger(LoginRestController.class);

	@Autowired
	private UserComponent userComponent;

	@RequestMapping("/api/logIn")
	public ResponseEntity<User> logIn() {

		if (!userComponent.isLoggedUser()) {
			log.info("No user logged");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			User loggedUser = userComponent.getLoggedUser();
			log.info("Logged as " + loggedUser.getName());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@RequestMapping("/api/logOut")
	public ResponseEntity<Boolean> logOut(HttpSession session) {

		if (!userComponent.isLoggedUser()) {
			log.info("No user logged");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			session.invalidate();
			log.info("Logged Out");
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
	}
}
