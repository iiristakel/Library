package model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Book {
    public int id;
    public String title;
    public int amount;
    public String location;
    public LocalDate insertingDate;
}
