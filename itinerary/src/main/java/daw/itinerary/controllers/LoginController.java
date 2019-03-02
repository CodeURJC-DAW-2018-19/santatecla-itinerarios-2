package daw.itinerary.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import daw.itinerary.user.User;
import daw.itinerary.user.UserComponent;

@Controller
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserComponent userComponent;

	/*@RequestMapping("/api/logIn")
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
	}*/
	
	@RequestMapping("/login")
	public String login(HttpSession session) {
		return "redirect:/units";
	}
	
	@GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
