package daw.itinerary.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByNameContaining(String name);
}
