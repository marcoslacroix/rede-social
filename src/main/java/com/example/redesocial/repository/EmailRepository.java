package com.example.redesocial.repository;


import com.example.redesocial.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
    Email findByEmail(String email);
}
