package com.example.demo.dto;

public record CharacterResponse(
        Long id,
        String name,
        int level,
        int proficiencyBonus,
        int exp,
        StatsDto stats
){}
