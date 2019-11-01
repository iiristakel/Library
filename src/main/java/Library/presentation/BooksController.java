package Library.presentation;

import Library.application.BookService;
import Library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BooksController {

    private final String CONTEXT = "/api/books";

    @Autowired
    private BookService bookService;

    @GetMapping(value = CONTEXT)
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(value = CONTEXT + "/search")
    public List<Book> searchBookByString(@RequestParam String search){
        return bookService.searchBookByString(search.toLowerCase());
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
