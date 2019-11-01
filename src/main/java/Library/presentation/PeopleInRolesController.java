package Library.presentation;

import Library.application.PeopleInRolesService;
import Library.model.PersonInRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PeopleInRolesController {
        private final String CONTEXT = "/api/peopleinroles";

        @Autowired
        private PeopleInRolesService peopleInRolesService;

        @PostMapping(value = CONTEXT)
        public void addPersonInRole(@RequestBody PersonInRole personInRole){
            peopleInRolesService.addPersonInRole(personInRole);
        }
}
