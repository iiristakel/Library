package Library.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "LENDING")
public class Lending {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Person person;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate lendingDate;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate returnDate;

    @Column
    private boolean bookReturned = false;

    @Column
    private int daysOver;

    @Column(name = "LENDINGDAYS")
    private int lendingDays;

    public void setLendingDays() {
        LocalDate date = LocalDate.now();
        int months = Period.between(book.getInsertingDate(), date).getMonths();
        if (book.getAmount() < 5 || months < 3){
            this.lendingDays = 7;
        } else{
            this.lendingDays = 28;
        }
    }

    public void setReturnDate() {
        this.returnDate = this.getLendingDate().plusDays(this.getLendingDays());
    }

    public void setDaysOver() {
        this.daysOver = Period.between(this.getReturnDate(), LocalDate.now()).getDays();
    }
}
