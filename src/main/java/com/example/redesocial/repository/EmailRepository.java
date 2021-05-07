package com.example.redesocial.repository;


import com.example.redesocial.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface EmailRepository extends JpaRepository<Email, Long> {
    Email findByEmail(String email);

    @Modifying
    @Query("update Email e set e.excluido = true where e.id = :emailId")
    void softDelete(@Param("emailId") Long emailId);
}
