package Library.presentation;

import Library.application.PersonService;
import Library.model.Person;
import Library.model.PersonInRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@RestController
public class PeopleController {
    private final String CONTEXT = "/api/people";
    private final Logger LOGGER = Logger.getLogger(PeopleController.class.getName());
    private FileHandler filehandler;

    public PeopleController(){
        try {
            filehandler = new FileHandler("PeopleServiceLog.log", 1024 * 8, 1, true);
            LOGGER.addHandler(filehandler);
            SimpleFormatter formatter = new SimpleFormatter();
            filehandler.setFormatter(formatter);
            LOGGER.setLevel(Level.FINE);
            filehandler.setLevel(Level.INFO);
        }catch(IOException io){
            System.out.println("Could not set logging.");
        }
    }

    @Autowired
    private PersonService personService;

    @GetMapping(value = CONTEXT + "/search")
    public List<Person> searchPersonByString(@RequestParam String search){
        LOGGER.info("Searching people by string: \"" + search + "\"");
        return personService.searchPersonByString(search.toLowerCase());
    }

    @GetMapping(value = CONTEXT)
    public List<PersonInRole> findPeopleByRole(@RequestParam String role){
        LOGGER.info("Searching people by role: \"" + role + "\"");
        return personService.findPeopleByRole(role.toLowerCase());
    }

    @PostMapping(value = CONTEXT)
    public void addPerson(@RequestBody Person person){
        LOGGER.info("Adding new person: " + person);
        personService.addPerson(person);
    }

    @DeleteMapping(value = CONTEXT + "/{id}")
    public void deletePerson(@PathVariable Long id){
        LOGGER.info("Deleting a person with id: " + id);
        personService.deletePersonById(id);
    }
}
