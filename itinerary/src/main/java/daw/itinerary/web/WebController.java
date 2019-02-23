package daw.itinerary.web;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
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

}
