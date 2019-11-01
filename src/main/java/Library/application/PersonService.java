package Library.application;

import Library.infrastructure.PersonRepository;
import Library.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

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

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }
}
