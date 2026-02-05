package com.example.demo.repository;

import com.example.demo.entity.Character.Race.RaceEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RaceRepository extends JpaRepository<RaceEntity, Long> {

    @EntityGraph(attributePaths = {"abilities", "bonuses"})
    List<RaceEntity> findAll();

    @EntityGraph(attributePaths = {"abilities", "bonuses"})
    Optional<RaceEntity> findById(Long id);
}
