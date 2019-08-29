package burak.SpringSecurityWithDatabase.repository;

import burak.SpringSecurityWithDatabase.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
