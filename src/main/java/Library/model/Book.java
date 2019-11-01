package Library.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "AMOUNT")
    private int amount;

    @Column(name = "SECTIONINLIBRARY")
    private String sectionInLibrary;

    @Column(name = "INSERTINGDATE")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate insertingDate = LocalDate.now();
}
