package com.example.demo.controller;

import com.example.demo.entity.Monster;
import com.example.demo.entity.model.MonsterType;
import com.example.demo.repository.BestiaryRepository;
import com.example.demo.service.BestiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/bestiary")
public class BestiaryController {

    private final BestiaryService bestiaryService;

    public BestiaryController(BestiaryService bestiaryService) {
        this.bestiaryService = bestiaryService;
    }

    @GetMapping("/filter/TypeAndCR")
    public List<Monster> searchByTypeAndChallengeRating(@RequestParam(required = false) MonsterType monsterType,
                                                        @RequestParam(required = false) Double challengeRating) {
        return bestiaryService.searchMonsterByTypeAndChallengeRating(monsterType, challengeRating);
    }

    @GetMapping("/filter/keyword")
    public List<Monster> searchByKeyword(@RequestParam(required = false) String keyword) {
        return bestiaryService.searchMonsterByDescriptionContainingIgnoreCase(keyword);
    }

    @GetMapping("/filter/name")
    public List<Monster> searchByName(@RequestParam(required = false) String name) {
        return bestiaryService.searchMonsterByNameContainingIgnoreCase(name);
    }

    @GetMapping
    public List<Monster> getAllMonsters() {
        return bestiaryService.getAll();
    }
}

