package Library.presentation;

import Library.application.LendingService;
import Library.model.Lending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@RestController
public class LendingsController {
    private final String CONTEXT = "/api/lendings";
    private final Logger LOGGER = Logger.getLogger(LendingsController.class.getName());
    private FileHandler filehandler;

    public LendingsController(){
        try {
            filehandler = new FileHandler("LendingServiceLog.log", 1024 * 8, 1, true);
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
    private LendingService lendingService;

    @GetMapping("/api/reports")
    public List<Lending> findAllOverdueLendings() {
        LOGGER.info("Returning all overdue lendings.");
        return lendingService.getAllOverdueLendings();
    }

    @PostMapping(value = CONTEXT)
    public Lending addLending(@RequestBody Lending lending) {
        LOGGER.info("Adding new Lending: " + lending);
        return lendingService.addOrUpdateLending(lending);
    }

    @PutMapping(value = CONTEXT)
    public Lending updateLending(@RequestBody Lending lending) {
        LOGGER.info("Updating a lending with data: " + lending);
        return lendingService.addOrUpdateLending(lending);
    }
}
