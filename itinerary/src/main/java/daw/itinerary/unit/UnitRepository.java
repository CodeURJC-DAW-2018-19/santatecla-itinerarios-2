package daw.itinerary.unit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long> {

    Unit findUnitById(long id);
    List<Unit> findByNameContaining(String name);
}