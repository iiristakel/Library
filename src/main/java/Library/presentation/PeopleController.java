package Library.presentation;

import Library.application.PersonService;
import Library.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PeopleController {
    private final String CONTEXT = "/api/people";

    @Autowired
    private PersonService personService;

    @GetMapping(value = CONTEXT + "/{id}")
    public Optional<Person> findPersonById(@PathVariable Long id){
        return personService.findPersonById(id);
    }

    @PostMapping(value = CONTEXT)
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @DeleteMapping(value = CONTEXT + "/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePersonById(id);
    }
}
