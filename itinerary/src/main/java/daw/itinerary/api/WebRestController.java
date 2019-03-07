package daw.itinerary.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import daw.itinerary.user.UserComponent;
/*
@RestController
public class WebRestController
{

	//@Autowired
	//private UnitService unitService;

	@Autowired
	private UserComponent userComponent;

	@ModelAttribute
	public void addUserToModel(Model model)
	{
		boolean logged = userComponent.getLoggedUser() != null;
		model.addAttribute("logged", logged);
		if(logged)
		{
			model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
			model.addAttribute("userName", userComponent.getLoggedUser().getName());
		}
	}


	@GetMapping("/error")
	public String error(Model model)
	{
		boolean logged = userComponent.getLoggedUser() != null;
		model.addAttribute("logged", logged);
		return "error";
	}


}*/
