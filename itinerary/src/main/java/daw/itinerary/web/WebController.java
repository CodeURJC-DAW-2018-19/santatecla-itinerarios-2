package daw.itinerary.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import daw.itinerary.unit.*;
import daw.itinerary.user.UserComponent;
import daw.itinerary.content.*;

@Controller
public class WebController {

	@Autowired
	private UnitService service;

	@Autowired
	private UserComponent userComponent;

	@Autowired
	private ContentService contentService;

	@ModelAttribute
	public void addUserToModel(Model model) {
		boolean logged = userComponent.getLoggedUser() != null;
		model.addAttribute("logged", logged);
		if (logged) {
			model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
			model.addAttribute("userName", userComponent.getLoggedUser().getName());
		}
	}

	@RequestMapping("/")
	public String index() {
		return "units";
	}

	@RequestMapping("/itinerary")
	public String itinerary() {
		return "itinerary";
	}

	@RequestMapping("/login")
	public String login(Model model) {

		model.addAttribute("hideLogin", true);
		return "login";
	}

	@RequestMapping("/units")
	public String units() {
		return "units";
	}

	@GetMapping("/contents")
	public String contents(Model model) {

		model.addAttribute("content", contentService.findAll());
		return "contents";
	}
}
