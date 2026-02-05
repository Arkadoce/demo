package com.example.demo.dto;

import java.util.List;

public record CharacterResponse(
        Long id,
        String name,
        int level,
        int proficiencyBonus,
        int exp,
        StatsDto stats,
        RaceShortDto race,
        List<RaceAbilityDto> raceAbilities
) {}
