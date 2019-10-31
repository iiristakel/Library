package Library.application;

import Library.infrastructure.persistence.RoleRepository;
import Library.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }

    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }
}
