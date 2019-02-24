package daw.itinerary.web;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import daw.itinerary.unit.*;
import daw.itinerary.content.*;
import daw.itinerary.itineraries.*;

@Controller
public class WebController {

	@Autowired
    private UnitService service;
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/")
	public String index () {
		return "units";
	}
	@RequestMapping("/itinerary")
	public String itinerary() {
		return "itinerary";
	}

	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request) {
		 
		 CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 model.addAttribute("token", token.getToken());

		 return "login";
	}
	
	@RequestMapping("/units")
	public String units() {
		return "units";
	}

	@GetMapping("/contents")
	public String contents(Model model) {
		
		model.addAttribute("content",contentService.findAll());
		return "contents";
	}
}
