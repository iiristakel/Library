package Library.application;

import java.util.List;

import Library.infrastructure.BookRepository;
import Library.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchBookByString(String search) {
        return bookRepository.findAllByTitleContainingOrAuthorContainingAllIgnoreCase(search, search);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
