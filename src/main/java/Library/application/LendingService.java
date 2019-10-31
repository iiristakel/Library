package Library.application;

import Library.infrastructure.persistence.LendingRepository;
import Library.model.Lending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LendingService {
    @Autowired
    private LendingRepository lendingRepository;

    public List<Lending> getAllLendings() {
        List<Lending> lendings = new ArrayList<>();
        lendingRepository.findAll().forEach(lendings::add);
        return lendings;
    }

    public Optional<Lending> findLendingById(Long id) {
        return lendingRepository.findById(id);
    }

    public List<Lending> findLendingsByBook(String title) {
        return lendingRepository.findByBookTitle(title);
    }

    public List<Lending> findLendingsByPerson(String name) {
        return lendingRepository.findByPersonName(name);
    }

    public void addLending(Lending lending) {
        lendingRepository.save(lending);
    }

    public void deleteLending(Long id) {
        lendingRepository.deleteById(id);
    }
}
