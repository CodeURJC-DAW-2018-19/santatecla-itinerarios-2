package daw.itinerary.content;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {

//    Page<Content> findAllByUnitId(long id, Pageable page);
	Collection<Content> findAllByUnitId(long id);
}
