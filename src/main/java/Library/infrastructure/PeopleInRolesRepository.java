package Library.infrastructure;

import Library.model.PersonInRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PeopleInRolesRepository extends CrudRepository<PersonInRole, Long> {
}
