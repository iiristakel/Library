package main;

import jdk.jshell.spi.ExecutionControl;
import model.Book;
import model.Person;
import model.Raport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BooksDao dao;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        throw new RuntimeException("not implemented yet");
    }

    @GetMapping("books/{id}")
    public Book findBook(@PathVariable Long id){
        throw new RuntimeException("not implemented yet");
    }

    @PostMapping("books/{id}")
    public void changeBookStatus(@PathVariable Long id){
        throw new RuntimeException("not implemented yet");
    }

    @PostMapping("/books")
    public void insertOrder(@RequestBody Book book){
        throw new RuntimeException("not implemented yet");
    }

    @DeleteMapping("books/{id}")
    public void deleteBook(@PathVariable Long id){
        throw new RuntimeException("not implemented yet");
    }
}
