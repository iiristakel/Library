package Library.infrastructure.persistence;

import Library.model.Lending;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LendingRepository extends CrudRepository<Lending, Long> {
    List<Lending> findByBookTitle(String title);
    List<Lending> findByPersonName(String name);
}
