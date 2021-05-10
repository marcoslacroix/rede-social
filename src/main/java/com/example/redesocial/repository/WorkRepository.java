package com.example.redesocial.repository;

import com.example.redesocial.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WorkRepository extends JpaRepository<Work, Long> {

    @Modifying
    @Query("update Work w set w.excluded = true where w.id = :workId")
    void softDelete(@Param("workId") Long workId);
}
