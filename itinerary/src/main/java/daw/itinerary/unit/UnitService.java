package daw.itinerary.unit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* This service will be used to include features to controller(s)
 */

@Service
public class UnitService {

	@Autowired
	private UnitRepository repository;

	public Optional<Unit> findOne(long id) {
		return repository.findById(id);
	}

	public List<Unit> findAll() {
		return repository.findAll();
	}

	public List<Unit> findByName(String name) {
		return repository.findByNameContaining(name);
	}

	public void save(Unit unit) {
		repository.save(unit);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
	
}