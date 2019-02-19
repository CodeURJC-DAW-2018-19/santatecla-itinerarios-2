package daw.itinerary.itineraries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItineraryService {

	@Autowired
	private ItineraryRepository repository;

	public Optional<Itinerary> findOne(long id) {
		return repository.findById(id);
	}

	public List<Itinerary> findAll() {
		return repository.findAll();
	}

	public void save(Itinerary book) {
		repository.save(book);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
}
