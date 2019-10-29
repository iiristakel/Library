package model;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    public int id;
    public int firstName;
    public int lastName;

    public List<PersonInRoles> personInRoles;

}
