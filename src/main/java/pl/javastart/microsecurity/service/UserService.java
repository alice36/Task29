package pl.javastart.microsecurity.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.javastart.microsecurity.model.User;
import pl.javastart.microsecurity.model.UserRole;
import pl.javastart.microsecurity.repository.UserRepository;
import pl.javastart.microsecurity.repository.UserRoleRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(String username, String password){

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEnabled(true);
        userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setUsername(username);
        userRole.setRole("ROLE_USER");
        userRoleRepository.save(userRole);

    }
}
