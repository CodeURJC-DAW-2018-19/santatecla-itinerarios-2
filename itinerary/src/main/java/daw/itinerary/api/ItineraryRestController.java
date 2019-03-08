package daw.itinerary.api;

import daw.itinerary.content.ContentService;
import daw.itinerary.itineraries.Itinerary;
import daw.itinerary.itineraries.ItineraryRepository;
import daw.itinerary.itineraries.ItineraryService;
import daw.itinerary.unit.Unit;
import daw.itinerary.unit.UnitService;
import daw.itinerary.user.UserComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ItineraryRestController
{
    @Autowired
    private UnitService unitService;

    @Autowired
    private ItineraryService itineraryService;
    
    @Autowired
	private UserComponent userComponent;

    @Autowired
    private ContentService contentService;

    @Autowired
    private ItineraryRepository repoItinerary;

    @RequestMapping("/api/itinerary")
    @ResponseStatus(HttpStatus.OK)
    public List<Itinerary> itinerary()
    {
        return repoItinerary.findAll();
    }

    @RequestMapping("/api/units/{unit_id}/itinerary/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Itinerary itinerary(Model model, @PathVariable long unit_id, @PathVariable long id)
    {
        return repoItinerary.findItineraryByIdAndUnitId(id, unit_id);
    }


    @RequestMapping("/api/units/{unit_id}/itineraries")
    @ResponseStatus(HttpStatus.OK)
    public Set<Itinerary> itinerary(Model model, @PathVariable long unit_id)
    {
        return repoItinerary.findAllByUnitId(unit_id);
    }

    @PostMapping("/api/units/{unit_id}/newItinerary")
    @ResponseStatus(HttpStatus.CREATED)
    public Itinerary addItinerary(@RequestBody Itinerary itinerary, @PathVariable long unit_id)
    {
        itinerary.setUnit(unitService.findOne(unit_id).get());
        itineraryService.save(itinerary);

        return itinerary;
    }

}
