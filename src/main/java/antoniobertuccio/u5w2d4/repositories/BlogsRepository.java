package antoniobertuccio.u5w2d4.repositories;

import antoniobertuccio.u5w2d4.entities.Author;
import antoniobertuccio.u5w2d4.entities.Blogpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogsRepository extends JpaRepository<Blogpost, Integer> {
  List<Blogpost> findByAuthor(Author author);
}
