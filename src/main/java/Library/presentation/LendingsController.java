package Library.presentation;

import Library.application.LendingService;
import Library.model.Lending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LendingsController {
    private final String CONTEXT = "/api/lendings";

    @Autowired
    private LendingService lendingService;

    @GetMapping(value = CONTEXT)
    public List<Lending> findAllLendings(@RequestParam String userName,
                                         @RequestParam String passwordHash) {
        return lendingService.getAllLendings();
    }

//    @GetMapping(value = CONTEXT)
//    public List<Lending> findLendingsByBookTitle(@RequestParam String userName,
//                                                 @RequestParam String passwordHash,
//                                                 @RequestParam String title) {
//        return lendingService.findLendingsByBook(title);
//    }

//    @GetMapping(value = CONTEXT)
//    public List<Lending> findLendingsByPersonName(@RequestParam String userName,
//                                                  @RequestParam String passwordHash,
//                                                  @RequestParam String name) {
//        return lendingService.findLendingsByPerson(name);
//    }

    @PostMapping(value = CONTEXT + "/{id}")
    public void addLending(@RequestParam String userName,
                                   @RequestParam String passwordHash,
                                   @RequestBody Lending lending) {
        lendingService.addLending(lending);
    }

    @DeleteMapping(value = CONTEXT + "/{id}")
    public void deleteLending(@RequestParam String userName,
                              @RequestParam String passwordHash,
                              @PathVariable Long id) {
        lendingService.deleteLending(id);
    }
}
