package Library.presentation;

import Library.application.RoleService;
import Library.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@RestController
public class RolesController {
    private final String CONTEXT = "/api/roles";

    @Autowired
    private RoleService roleService;

    @GetMapping(value = CONTEXT)
    public List<Role> getRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping(value = CONTEXT + "/{id}")
    public Optional<Role> getRoleById(@PathVariable Long id){
        return roleService.getRoleById(id);
    }

    @PostMapping(value = CONTEXT)
    public void addRole(@RequestBody Role role){
        roleService.addRole(role);
    }

    @DeleteMapping(value = CONTEXT + "/{id}")
    public void deleteRoleById(@PathVariable Long id){
        roleService.deleteRoleById(id);
    }
}
