package daw.itinerary.unit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnitController {
    
    @Autowired
    private UnitRepository repository;
    
    @PostConstruct
    public void init(){
        repository.save(new Unit("Año 1989"));
        repository.save(new Unit("CERN"));
        repository.save(new Unit("Tim Berners Lee"));
        repository.save(new Unit("JavaScript"));
    }

    @RequestMapping("/")
    public String listaUnits(Model model){
        model.addAttribute("units", repository.findAll());

        return "listaUnits";
    }
}