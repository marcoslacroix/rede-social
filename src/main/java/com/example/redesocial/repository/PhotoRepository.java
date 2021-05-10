package com.example.redesocial.repository;

import com.example.redesocial.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    Optional<Photo> findByUserId(Long userId);
}
