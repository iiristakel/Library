package Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "book")
    private List<Lending> lendings;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private int amount;

    @Column
    private int lendingDays;

    @Column
    private String sectionInLibrary;

    @Column
    private LocalDate insertingDate;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "book")
    private List<Report> reports;

}
