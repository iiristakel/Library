package Library.presentation;

import Library.application.BookService;
import Library.application.ReportService;
import Library.model.Book;
import Library.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReportsController {

    private final String CONTEXT = "/api/reports";

    @Autowired
    private ReportService reportService;

    @PostMapping(value = CONTEXT)
    public List<Report> getReports(@RequestParam String userName,
                                   @RequestParam String passwordHash){
        // if person is in role "library worker"...
        return reportService.getAllReports();
    }

    @DeleteMapping(value = CONTEXT + "/{id}")
    public void deleteReportById(@RequestParam String userName,
                                 @RequestParam String passwordHash,
                                 @PathVariable Long id){
        reportService.deleteReportById(id);
    }
}
