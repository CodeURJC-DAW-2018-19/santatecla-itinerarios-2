package daw.itinerary.controllers;

import daw.itinerary.itineraries.ItineraryService;
import daw.itinerary.unit.Unit;
import daw.itinerary.unit.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItineraryController
{
    @Autowired
    private UnitService unitService;

    @Autowired
    private ItineraryService itineraryService;

    @RequestMapping("/itinerary")
    public String itinerary()
    {
        return "itinerary";
    }

    @RequestMapping("/units/{unit_id}/itinerary/{id}")
    public String itinerary(Model model, @PathVariable long unit_id)
    {
        Unit unit = unitService.findOne(unit_id).get();
        model.addAttribute("units", unit);
        model.addAttribute("unit", unitService.findAll());
        model.addAttribute("itineraries", unit.getContents());

        return "itinerary";
    }
}
