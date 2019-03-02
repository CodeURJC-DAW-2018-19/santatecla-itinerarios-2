package daw.itinerary.controllers;

import daw.itinerary.content.Content;
import daw.itinerary.content.ContentService;
import daw.itinerary.unit.Unit;
import daw.itinerary.unit.UnitService;
import daw.itinerary.user.UserComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController
{
    @Autowired
    private UnitService unitService;

    @Autowired
    private ContentService contentService;

    @Autowired
	private UserComponent userComponent;

    @RequestMapping("/units/{id}/contents")
    public String contents(Model model, @PathVariable long id, Pageable page)
    {
    	boolean logged = userComponent.getLoggedUser() != null;
		model.addAttribute("logged", logged);

        Page<Content> contents = contentService.findAll(new PageRequest(0, 10));
        model.addAttribute("contentsPage", contents);

        Unit unit = unitService.findOne(id).get();
        model.addAttribute("units", unit);
        model.addAttribute("unit", unitService.findAll());
        model.addAttribute("contents", unit.getContents());
        
        if(logged)
		{
			model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
		}
        return "contents";
    }
}
