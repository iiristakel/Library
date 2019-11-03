package Library.presentation;

import Library.application.BookService;
import Library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@RestController
public class BooksController {

    private final String CONTEXT = "/api/books";
    private final Logger LOGGER = Logger.getLogger(BooksController.class.getName());
    private FileHandler filehandler;

    public BooksController(){
        try {
            filehandler = new FileHandler("BookServiceLog.log", 1024 * 8, 1, true);
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
    private BookService bookService;

    @GetMapping(value = CONTEXT)
    public List<Book> getBooks(){

        LOGGER.info("Returning list of Books.");
        return bookService.getAllBooks();
    }

    @GetMapping(value = CONTEXT + "/search")
    public List<Book> searchBookByString(@RequestParam String search){
        LOGGER.info("Searching books by string: \"" + search + "\".");
        return bookService.searchBookByString(search.toLowerCase());
    }

    @PostMapping(value = CONTEXT)
    public void addBook(@RequestBody Book book){
        LOGGER.info("Adding new book: " + book);
        bookService.addBook(book);
    }

    @DeleteMapping(value = CONTEXT + "/{id}")
    public void deleteBookById(@PathVariable Long id){
        LOGGER.info("Deleting book with id: " + id);
        bookService.deleteBookById(id);
    }
}
