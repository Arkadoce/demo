package com.example.demo.repository;

import com.example.demo.entity.bestiary.Monster;
import com.example.demo.entity.model.MonsterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BestiaryRepository extends JpaRepository<Monster, Long> {
    public List<Monster> findByNameContainingIgnoreCase(String name);
    public List<Monster> findByType(MonsterType type);
    public List<Monster> findByChallengeRating(Double challengeRating);
    public List<Monster> findByDescriptionContainingIgnoreCase(String keyword);
    public List<Monster> findByTypeAndChallengeRating(MonsterType type, Double challengeRating);
}




