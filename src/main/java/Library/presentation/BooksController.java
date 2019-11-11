package Library.presentation;

import java.util.List;

import Library.application.BookService;
import Library.model.Book;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BooksController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BooksController.class);

    private static final String PATH = "/api/books";

    private final BookService bookService;

    @GetMapping(PATH)
    public List<Book> getBooks() {
        LOGGER.info("Returning list of Books.");
        return bookService.getAllBooks();
    }

    @GetMapping(PATH + "/search")
    public List<Book> searchBookByString(@RequestParam String search) {
        LOGGER.info("Searching books by string: {}", search);
        return bookService.searchBookByString(search);
    }

    @PostMapping(PATH)
    // FIXME: should use dto instead of Book entity class
    public void addBook(@RequestBody Book book) {
        LOGGER.info("Adding new book: {}", book);
        bookService.addBook(book);
    }

    @DeleteMapping(PATH + "/{id:\\d}")
    public void deleteBookById(@PathVariable Long id) {
        LOGGER.info("Deleting book with id: {}", id);
        bookService.deleteBookById(id);
    }
}
