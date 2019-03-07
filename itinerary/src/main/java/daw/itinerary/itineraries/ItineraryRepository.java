package daw.itinerary.itineraries;

import daw.itinerary.unit.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

    // Lo busca shenron
    Itinerary findItineraryByIdAndUnitId(long itId, long unId);
    Set<Itinerary> findAllByUnitId(long id);
}
