package daw.itinerary.controllers;

import daw.itinerary.unit.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItineraryController
{
    @Autowired
    private UnitService unitService;

    @RequestMapping("/itinerary")
    public String itinerary()
    {
        return "itinerary";
    }

    @RequestMapping("/units/{units_id}/itinerary")
    public String itinerary(Model model)
    {
        model.addAttribute("unit", unitService.findAll());
//		model.addAttribute("unit", unitService.findOne(id));
//		model.addAttribute("itinerary", itService.findAll());
        return "itinerary";
    }
}
