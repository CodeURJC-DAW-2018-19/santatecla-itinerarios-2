package daw.itinerary.controllers;

import daw.itinerary.content.Content;
import daw.itinerary.content.ContentService;
import daw.itinerary.unit.Unit;
import daw.itinerary.unit.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController
{
    @Autowired
    private UnitService unitService;

    @RequestMapping("/units/{id}/contents")
    public String contents(Model model, @PathVariable long id)
    {
        Unit unit = unitService.findOne(id).get();
        model.addAttribute("units", unit);
        model.addAttribute("unit", unitService.findAll());
        model.addAttribute("contents", unit.getContents());
        return "contents";
    }
}
