package Library.application;

import Library.infrastructure.PeopleInRolesRepository;
import Library.model.PersonInRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleInRolesService {
    @Autowired
    private PeopleInRolesRepository peopleInRolesRepository;

    public void addPersonInRole(PersonInRole personInRole) {
        peopleInRolesRepository.save(personInRole);
    }
}
