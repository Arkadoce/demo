package com.example.demo.repository;

import com.example.demo.entity.Race.RaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RaceRepository extends JpaRepository<RaceEntity, Long> {

    Optional<RaceEntity> findByName(String name);

}
