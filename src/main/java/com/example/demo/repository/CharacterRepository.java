package com.example.demo.repository;

import com.example.demo.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
}
