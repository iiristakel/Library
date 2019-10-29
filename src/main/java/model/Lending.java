package model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Lending {
    public int id;
    public Book book;
    public LocalDate lendingDate;
    public LocalDate returnDate;
}
