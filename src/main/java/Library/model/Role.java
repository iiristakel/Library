package Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
