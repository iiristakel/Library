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
public class PeopleInRolesController {
        private final String CONTEXT = "/api/peopleinroles";

        @Autowired
        private PeopleInRolesService peopleInRolesService;

//        @GetMapping(value = CONTEXT)
//        public List<Person> getPeopleInRole(@RequestParam String role){
//            return peopleInRolesService.getAllPeopleInRole(role);
//        }

        @GetMapping(value = CONTEXT)
        public List<PersonInRole> getAllPeopleInRoles(){
                return peopleInRolesService.getAllPeopleInRoles();
        }


        @PostMapping(value = CONTEXT)
        public void addPersonInRole(@RequestBody PersonInRole personInRole){
            peopleInRolesService.addPersonInRole(personInRole);
        }

        @DeleteMapping(value = CONTEXT + "/{id}")
        public void removePersonFromRole(@PathVariable Long id){
            peopleInRolesService.removePersonFromRole(id);
        }

}
