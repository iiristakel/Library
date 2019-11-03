package Library.application;

import Library.infrastructure.PeopleInRolesRepository;
import Library.infrastructure.PersonRepository;
import Library.model.Person;
import Library.model.PersonInRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PeopleInRolesRepository peopleInRolesRepository;

    public List<Person> searchPersonByString(String search) {
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(
                person -> {
                    if (person.getName().toLowerCase().contains(search) ||
                            person.getEmail().toLowerCase().contains(search)){
                        people.add(person);
                    }
                }
        );
        return people;
    }

    public List<PersonInRole> findPeopleByRole(String role) {
        List<PersonInRole> peopleInRole = new ArrayList<>();
        peopleInRolesRepository.findAll().forEach(
                personInRole -> {
                    if (personInRole.getRole().getTitle().toLowerCase().equals(role)) {
                        peopleInRole.add(personInRole);
                    }
                }
        );
        return peopleInRole;
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }
}
