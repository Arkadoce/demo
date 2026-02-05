package com.example.demo.repository;

import com.example.demo.entity.Character.CharacterEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
    @EntityGraph(attributePaths = {
            "race",
            "race.abilities"
    })
    Optional<CharacterEntity> findById(Long id);
    @EntityGraph(attributePaths = {
            "race",
            "race.abilities"
    })
    List<CharacterEntity> findAll();

}
