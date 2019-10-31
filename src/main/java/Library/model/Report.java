package Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "REPORT")
public class Report {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Book book;

    @Column
    private int daysOver;
}
