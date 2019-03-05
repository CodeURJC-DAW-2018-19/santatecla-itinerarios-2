package daw.itinerary.api;

import daw.itinerary.content.ContentService;
import daw.itinerary.unit.Unit;
import daw.itinerary.unit.UnitService;
import daw.itinerary.user.UserComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItineraryRestController
{
    @Autowired
    private UnitService unitService;
    
    @Autowired
	private UserComponent userComponent;

    @Autowired
    private ContentService contentService;

    @RequestMapping("/itinerary")
    public String itinerary()
    {
        return "itinerary";
    }

    @RequestMapping("/units/{unit_id}/itinerary/{id}")
    public String itinerary(Model model, @PathVariable long unit_id)
    {
    	boolean logged = userComponent.getLoggedUser() != null;
		model.addAttribute("logged", logged);
        Unit unit = unitService.findOne(unit_id).get();
        model.addAttribute("units", unit);
        model.addAttribute("unit", unitService.findAll());
        model.addAttribute("contents", contentService.findAll());
        model.addAttribute("itineraries", unit.getItineraries());

        return "itinerary";
    }
}
