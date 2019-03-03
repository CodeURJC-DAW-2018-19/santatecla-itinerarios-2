package daw.itinerary.content;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* This service will be used to include features to controller(s)
 */

@Service
public class ContentService {

	@Autowired
	private ContentRepository repository;

	public Optional<Content> findOne(long id) {
		return repository.findById(id);
	}

	public List<Content> findAll() {
		return repository.findAll();
	}

    public Page<Content> findAll(Pageable page) {
        return repository.findAll(page);
    }

	public void save(Content content) {
		repository.save(content);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
}