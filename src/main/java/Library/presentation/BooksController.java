package Library.presentation;

import Library.application.BookService;
import Library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {

    private final String CONTEXT = "/api/books";

    @Autowired
    private BookService bookService;

    @GetMapping(value = CONTEXT)
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(value = CONTEXT + "/{id}")
    public Optional<Book> findBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @PostMapping(value = CONTEXT)
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @DeleteMapping(value = CONTEXT + "/{id}")
    public void deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
    }
}
