package com.example.demo.service;

import com.example.demo.entity.bestiary.Monster;
import com.example.demo.entity.model.MonsterType;
import com.example.demo.repository.BestiaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestiaryService {

    private final BestiaryRepository bestiaryRepository;

    public BestiaryService(BestiaryRepository bestiaryRepository) {
        this.bestiaryRepository = bestiaryRepository;
    }

    public List<Monster> getAll() {
        return bestiaryRepository.findAll();
    }

    public List<Monster> searchMonsterByTypeAndChallengeRating(MonsterType type, Double challengeRating) {
        if (type != null && challengeRating != null) {
            return bestiaryRepository.findByTypeAndChallengeRating(type, challengeRating);
        } else if (type != null) {
            return bestiaryRepository.findByType(type);
        } else if (challengeRating != null) {
            return bestiaryRepository.findByChallengeRating(challengeRating);
        }
        return bestiaryRepository.findAll();
    }

    public List<Monster> searchMonsterByDescriptionContainingIgnoreCase(String keyword) {
        if (keyword != null) {
            return bestiaryRepository.findByDescriptionContainingIgnoreCase(keyword);
        } else {
            return bestiaryRepository.findAll();
        }
    }

    public List<Monster> searchMonsterByNameContainingIgnoreCase(String name) {
        if (name != null) {
            return bestiaryRepository.findByNameContainingIgnoreCase(name);
        } else {
            return bestiaryRepository.findAll();
        }
    }

    public void createMonster() {}
}

