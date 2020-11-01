package ru.greenatom.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.greenatom.edu.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
