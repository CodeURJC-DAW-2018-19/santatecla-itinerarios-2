package daw.itinerary.controllers;

import daw.itinerary.unit.Unit;
import daw.itinerary.unit.UnitService;
import daw.itinerary.user.UserComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UnitController
{
    @Autowired
    private UnitService unitService;
    
    @Autowired
	private UserComponent userComponent;

	@RequestMapping("/")
	public String index() {

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

	@GetMapping("/units/newUnit/")
	public String newUnit() {

		return "newUnit";
	}

	@PostMapping("/units/newUnit/save")
	public String unitCreated(Model model, @RequestParam("name") String name) {
		if (!name.isEmpty()) {
			Unit unit = new Unit(name);
			unitService.save(unit);
		}
		return "redirect:/units";
	}
}
