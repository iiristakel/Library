package Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "person")
    private List<Lending> lendings;

//    @OneToMany(cascade=CascadeType.ALL, mappedBy = "person")
//    private List<PersonInRole> personInRoles;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "person")
    private List<Report> reports;
}
