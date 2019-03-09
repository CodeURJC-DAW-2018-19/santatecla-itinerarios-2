package daw.itinerary.api;

import daw.itinerary.unit.Unit;
import daw.itinerary.unit.UnitService;
import daw.itinerary.user.UserComponent;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitRestController {

	@Autowired
	private UnitService unitService;

	@Autowired
	private UserComponent userComponent;

	@RequestMapping("/api/units")
	public Collection<Unit> index(Model model) {
		return unitService.findAll();
	}
	
	@GetMapping("/api/units/{id}")
	public Unit getUnit(@PathVariable long id) {
		return unitService.findOne(id).get();
	}

	@PostMapping("/api/units/newUnit")
	@ResponseStatus(HttpStatus.CREATED)
	public Unit createUnit(@RequestBody Unit unit) {
		unitService.save(unit);
		return unit;
	}
	
	@DeleteMapping("/api/units/{id}/deleteUnit")
	public Unit deleteContent(@PathVariable("id") long id) {
		Unit unit = unitService.findOne(id).get();
		if (unitService.findOne(id).isPresent()) {
			unitService.delete(id);
			return unit;
		}

		return unit;
	}
	
}
