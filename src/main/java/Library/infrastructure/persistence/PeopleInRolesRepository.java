package Library.infrastructure.persistence;

import Library.model.Person;
import Library.model.PersonInRole;
import Library.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleInRolesRepository extends CrudRepository<PersonInRole, Long> {
    List<PersonInRole> findByRoleTitle(String title);
    List<PersonInRole> findByPersonName(String name);

}
