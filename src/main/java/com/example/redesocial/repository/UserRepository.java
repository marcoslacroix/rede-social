package com.example.redesocial.repository;

import com.example.redesocial.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailPrincipal(String email);

    User findByUuid(String uuid);
}
