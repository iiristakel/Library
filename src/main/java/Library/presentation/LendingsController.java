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

    @GetMapping("/api/reports")
    public List<Lending> findAllLateLendings() {
        return lendingService.getAllLateLendings();
    }

    @PostMapping(value = CONTEXT)
    public Lending addLending(@RequestBody Lending lending) {
        System.out.println(lending);
        return lendingService.addLending(lending);
    }

    @PutMapping(value = CONTEXT)
    public Lending updateLending(@RequestBody Lending lending) {
        return lendingService.updateLending(lending);
    }
}
