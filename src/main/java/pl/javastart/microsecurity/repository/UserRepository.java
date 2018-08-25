package pl.javastart.microsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.javastart.microsecurity.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u from User u " +
            "where u.username = :letter")
    User findUserUsingUsername(@Param("letter") String name);
}
