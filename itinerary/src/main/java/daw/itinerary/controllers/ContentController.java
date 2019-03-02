package daw.itinerary.controllers;

import daw.itinerary.unit.UnitService;
import daw.itinerary.user.UserComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController
{
    @Autowired
    private UnitService unitService;
    
    @Autowired
	private UserComponent userComponent;

    @RequestMapping("/units/{units_id}/contents")
    public String contents(Model model)
    {
    	boolean logged = userComponent.getLoggedUser() != null;
		model.addAttribute("logged", logged);
        model.addAttribute("unit", unitService.findAll());
        return "contents";
    }
}
