package daw.itinerary.controllers;

import daw.itinerary.unit.UnitService;
import daw.itinerary.user.UserComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnitController
{
    @Autowired
    private UnitService unitService;
    
    @Autowired
	private UserComponent userComponent;

    @RequestMapping("/")
    public String index()
    {

        return "redirect:units";
    }

    @RequestMapping("/units")
    public String units(Model model)
    {
    	boolean logged = userComponent.getLoggedUser() != null;
    	model.addAttribute("logged", logged);
        model.addAttribute("unit", unitService.findAll());

        return "units";
    }
}
