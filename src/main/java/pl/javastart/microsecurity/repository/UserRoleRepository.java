package pl.javastart.microsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.microsecurity.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
