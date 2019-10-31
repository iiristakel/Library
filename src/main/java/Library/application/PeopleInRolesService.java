package Library.application;

import Library.infrastructure.persistence.PeopleInRolesRepository;
import Library.model.Book;
import Library.model.Person;
import Library.model.PersonInRole;
import Library.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleInRolesService {
    @Autowired
    private PeopleInRolesRepository peopleInRolesRepository;

    public List<Person> getAllPeopleInRole(String roleTitle) {
        List<Person> people = new ArrayList<>();
        peopleInRolesRepository.findByRoleTitle(roleTitle).forEach(personInRole -> people.add(personInRole.getPerson()));
        return people;
    }

    public List<PersonInRole> getAllPeopleInRoles(){
        List<PersonInRole> peopleInRole = new ArrayList<>();
        peopleInRolesRepository.findAll().forEach(peopleInRole::add);
        return peopleInRole;
    }

    public Person findPersonByName(String name) {
        List<PersonInRole> personInRoles = peopleInRolesRepository.findByPersonName(name);
        return personInRoles.get(0).getPerson();
    }

    public void addPersonInRole(PersonInRole personInRole) {
        peopleInRolesRepository.save(personInRole);
    }

    public void removePersonFromRole(Long id) {
        peopleInRolesRepository.deleteById(id);
    }

}
