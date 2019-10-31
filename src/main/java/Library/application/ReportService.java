package Library.application;

import Library.infrastructure.persistence.BookRepository;
import Library.infrastructure.persistence.ReportRepository;
import Library.model.Book;
import Library.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReports() {
        List<Report> reports = new ArrayList<>();
        reportRepository.findAll().forEach(reports::add);
        return reports;
    }

    public void deleteReportById(Long id) {
        reportRepository.deleteById(id);
    }
}
