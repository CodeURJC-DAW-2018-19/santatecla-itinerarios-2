package daw.itinerary.api;

import daw.itinerary.unit.Unit;
import daw.itinerary.unit.UnitService;
import daw.itinerary.user.UserComponent;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitRestController
{
    @Autowired
    private UnitService unitService;
    
    @Autowired
	private UserComponent userComponent;

	@RequestMapping("/api")
	public Collection<Unit> index(Model model) {
		return unitService.findAll();
	}

    @RequestMapping("/api/units")
    public String units(Model model)
    {
    	boolean logged = userComponent.getLoggedUser() != null;
    	model.addAttribute("logged", logged);
        model.addAttribute("unit", unitService.findAll());
        if(logged)
		{
			model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
		}

		return "units";
	}

	@GetMapping("/api/units/newUnit/")
	public String newUnit(Model model) {

		boolean logged = userComponent.getLoggedUser() != null;
		model.addAttribute("logged", logged);
		return "newUnit";
	}

	@PostMapping("/api/units/newUnit/save")
	public String unitCreated(Model model, @RequestParam("name") String name) {
		if (!name.isEmpty()) {
			Unit unit = new Unit(name);
			unitService.save(unit);
		}
		return "redirect:/units";
	}
}
