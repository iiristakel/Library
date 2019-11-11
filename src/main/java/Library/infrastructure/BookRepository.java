package Library.infrastructure;

import java.util.List;

import Library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    List<Book> findAllByTitleContainingOrAuthorContainingAllIgnoreCase(
            String titleSearchString, String authorSearchString);
}
