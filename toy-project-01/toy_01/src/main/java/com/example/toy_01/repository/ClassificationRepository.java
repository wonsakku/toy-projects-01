package com.example.toy_01.repository;

import com.example.toy_01.domain.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClassificationRepository extends JpaRepository<Classification, Long> {

    @Query("SELECT c FROM Classification c WHERE c.id IN :classificationIds")
    Optional<List<Classification>> findClassificationByIds(@Param("classificationIds") List<Long> classificationIds);
}
