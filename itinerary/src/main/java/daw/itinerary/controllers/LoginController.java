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
