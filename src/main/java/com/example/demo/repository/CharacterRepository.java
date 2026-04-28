package com.example.demo.repository;

import com.example.demo.entity.CharacterClass;
import com.example.demo.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
    CharacterClass findByName(String name);
}
