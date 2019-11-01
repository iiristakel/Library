package Library.application;

import Library.infrastructure.BookRepository;
import Library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

        public List<Book> searchBookByString(String search) {
            List<Book> books = new ArrayList<>();
            bookRepository.findAll().forEach(
                    book -> {
                        if (book.getTitle().toLowerCase().contains(search) ||
                        book.getAuthor().toLowerCase().contains(search)){
                            books.add(book);
                        }
                    }
            );
            return books;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
