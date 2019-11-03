package Library.presentation;

import Library.application.PeopleInRolesService;
import Library.model.PersonInRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


@RestController
public class PeopleInRolesController {
        private final String CONTEXT = "/api/peopleinroles";
        private final Logger LOGGER = Logger.getLogger(PeopleInRolesController.class.getName());
        private FileHandler filehandler;

        public PeopleInRolesController(){
                try {
                        filehandler = new FileHandler("PeopleInRolesServiceLog.log", 1024 * 8, 1, true);
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
        private PeopleInRolesService peopleInRolesService;

        @PostMapping(value = CONTEXT)
        public void addPersonInRole(@RequestBody PersonInRole personInRole){
                LOGGER.info("Adding a person into role with data: " + personInRole);
                peopleInRolesService.addPersonInRole(personInRole);
        }
}
