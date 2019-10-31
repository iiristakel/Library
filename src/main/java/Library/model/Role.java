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
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "role")
    private List<PersonInRole> personsInRole;
}
