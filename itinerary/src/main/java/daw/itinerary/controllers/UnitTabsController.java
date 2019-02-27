package daw.itinerary.controllers;

import daw.itinerary.unit.Unit;
import daw.itinerary.unit.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class UnitTabsController
{
    @Autowired
    private UnitService unitService;

    @GetMapping("/units/{id}")
    public String addUnitToTab(Model model, @PathVariable long id)
    {
        Optional<Unit> unit = unitService.findOne(id);

        if(unit.isPresent())
        {
            model.addAttribute("unit", unit.get());
        }

        return "header";
    }
}
