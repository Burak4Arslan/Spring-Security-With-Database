package burak.SpringSecurityWithDatabase.service;

import burak.SpringSecurityWithDatabase.entity.Role;
import burak.SpringSecurityWithDatabase.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }
}
