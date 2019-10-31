package Library.application;

import Library.infrastructure.persistence.BookRepository;
import Library.infrastructure.persistence.PersonRepository;
import Library.model.Book;
import Library.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(people::add);
        return people;
    }

    public Optional<Person> findPersonById(Long id) {
        return personRepository.findById(id);
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }
}
