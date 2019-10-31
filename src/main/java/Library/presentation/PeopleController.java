package Library.presentation;

import Library.application.PeopleInRolesService;
import Library.application.PersonService;
import Library.model.Person;
import Library.model.PersonInRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PeopleController {
    private final String CONTEXT = "/api/people";

    @Autowired
    private PeopleInRolesService peopleInRolesService;

    @Autowired
    private PersonService personService;

    @GetMapping(value = CONTEXT)
    public List<Person> getPeopleInRole(@RequestParam String userName,
                                        @RequestParam String passwordHash,
                                        @RequestParam String role){
        return peopleInRolesService.getAllPeopleInRole(role);
    }

    @GetMapping(value = CONTEXT + "/{id}")
    public Optional<Person> findPersonById(@RequestParam String userName,
                                           @RequestParam String passwordHash,
                                           @PathVariable Long id){
        return personService.findPersonById(id);
    }

//    @GetMapping(value = CONTEXT)
//    public Person findPersonByName(@RequestParam String userName,
//                                   @RequestParam String passwordHash,
//                                   @RequestParam String name){
//        return peopleInRolesService.findPersonByName(name);
//    }

    @PostMapping(value = CONTEXT)
    public void addPersonInRole(@RequestParam String userName,
                                @RequestParam String passwordHash,
                                @RequestBody PersonInRole personInRole){
        peopleInRolesService.addPersonInRole(personInRole);
    }

    @DeleteMapping(value = CONTEXT + "/{id}")
    public void removePersonFromRole(@RequestParam String userName,
                                     @RequestParam String passwordHash,
                                     @PathVariable Long id){
        peopleInRolesService.removePersonFromRole(id);
    }
}
