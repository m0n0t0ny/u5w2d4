package antoniobertuccio.u5w2d4.repositories;

import antoniobertuccio.u5w2d4.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorsRepository extends JpaRepository<Author, Integer> {
  Optional<Author> findByEmail(String email);

  boolean existsByEmail(String email);
}
