package daw.itinerary.api;

import daw.itinerary.content.Content;
import daw.itinerary.content.ContentRepository;
import daw.itinerary.content.ContentService;
import daw.itinerary.unit.Unit;
import daw.itinerary.unit.UnitService;
import daw.itinerary.user.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentRestController
{
    @Autowired
    private UnitService unitService;

    @Autowired
    private ContentService contentService;

    @Autowired
    private ContentRepository repo;

    @Autowired
    private UserComponent userComponent;

    @RequestMapping("/units/{id}/contents")
    public String contents(Model model, @PathVariable long id, @PageableDefault(size = 10) Pageable page)
    {
        boolean logged = userComponent.getLoggedUser() != null;
        model.addAttribute("logged", logged);

        Page<Content> contents = repo.findAllByUnitId(id, page);
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

    @RequestMapping("/units/{id}/contents/list")
    public String contentsList(Model model, @PathVariable long id, @PageableDefault(size = 10) Pageable page)
    {
        boolean logged = userComponent.getLoggedUser() != null;
        model.addAttribute("logged", logged);

        Page<Content> contents = repo.findAllByUnitId(id, page);
        model.addAttribute("contentsPage", contents);

        Unit unit = unitService.findOne(id).get();
        model.addAttribute("units", unit);
        model.addAttribute("unit", unitService.findAll());
        model.addAttribute("contents", unit.getContents());

        if(logged)
        {
            model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
        }
        return "contentsList";
    }
}
