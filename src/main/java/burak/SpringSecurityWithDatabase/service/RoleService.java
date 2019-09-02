package burak.SpringSecurityWithDatabase.service;

import burak.SpringSecurityWithDatabase.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();
    Role findById(Long id);
    Role findByRole(String role);

}
