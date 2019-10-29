package main;

import model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LendersController {

    @GetMapping("lenders/{id}")
    public Person findLender(@PathVariable Long id){
        throw new RuntimeException("not implemented yet");
    }

    @PostMapping("books/{id}")
    public void addLender(@PathVariable Long id){
        throw new RuntimeException("not implemented yet");
    }
}
