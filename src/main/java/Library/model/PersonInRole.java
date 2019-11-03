package Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PERSONINROLE")
public class PersonInRole {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;

    @ManyToOne
    private Role role;

    @Column
    private LocalDate startDate;


    public void setStartDate() {
        this.startDate  = LocalDate.now();
    }
}
