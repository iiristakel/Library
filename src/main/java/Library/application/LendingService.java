package Library.application;

import Library.infrastructure.BookRepository;
import Library.infrastructure.LendingRepository;
import Library.infrastructure.PersonRepository;
import Library.model.Lending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LendingService {
    @Autowired
    private LendingRepository lendingRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<Lending> getAllLateLendings() {
        List<Lending> lateLendings = new ArrayList<>();
        lendingRepository.findAll().forEach(lending -> {
            int daysOver = lending.getDaysOver();
            if (daysOver > 0){
                lateLendings.add(lending);
            }
        });
        return lateLendings;
    }

    public Lending addLending(Lending lending) {
        lending.setLendingDays();
        lending.setReturnDate();
        lending.setDaysOver();
        lending.setBook(bookRepository.findById(lending.getBook().getId()).get());
        lending.setPerson(personRepository.findById(lending.getPerson().getId()).get());

        return lendingRepository.save(lending);
    }

    public Lending updateLending(Lending lending) {
        lending.setLendingDays();
        lending.setReturnDate();
        lending.setDaysOver();
        lending.setBook(bookRepository.findById(lending.getBook().getId()).get());
        lending.setPerson(personRepository.findById(lending.getPerson().getId()).get());

        return lendingRepository.save(lending);
    }
}
