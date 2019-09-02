package burak.SpringSecurityWithDatabase.repository;

import burak.SpringSecurityWithDatabase.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(String role);
}
