package model;

import lombok.Data;

@Data
public class Raport {
    public int id;
    public Person person;
    public Book book;
    public int daysOver;
}
