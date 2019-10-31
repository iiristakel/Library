package Library.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "AMOUNT")
    private int amount;

    @Column(name = "LENDINGDAYS")
    private int lendingDays;

    @Column(name = "SECTIONINLIBRARY")
    private String sectionInLibrary;

    @Column(name = "INSERTINGDATE")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate insertingDate;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "book")
    private List<Lending> lendings;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "book")
    private List<Report> reports;

    public int getLendingDays() {
        LocalDate date = LocalDate.now();
        int months = Period.between(getInsertingDate(), date).getMonths();
        if (getAmount() < 5 || months < 3){
            this.lendingDays = 7;
        } else{
            this.lendingDays = 28;
        }
        return this.lendingDays;
    }
}
