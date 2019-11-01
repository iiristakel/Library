package Library.infrastructure;

import Library.model.Lending;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LendingRepository extends CrudRepository<Lending, Long> {
}
