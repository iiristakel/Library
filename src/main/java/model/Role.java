package model;

import lombok.Data;

import java.util.List;

@Data
public class Role {

    public int id;
    public String roleName;

    public List<PersonInRoles> personsInRole;
}
