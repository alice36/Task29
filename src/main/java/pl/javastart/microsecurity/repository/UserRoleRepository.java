package pl.javastart.microsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.javastart.microsecurity.model.User;
import pl.javastart.microsecurity.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    @Query("SELECT u from UserRole u " +
            "where u.username = :letter")
    UserRole findUserRoleUsingUsername(@Param("letter") String name);
}
