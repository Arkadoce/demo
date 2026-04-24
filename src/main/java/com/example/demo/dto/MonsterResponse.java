package com.example.demo.dto;

import java.util.List;

public record MonsterResponse(
        Long id,
        String name,
        String description,
        String size,
        String type,
        String alignment,
        String habitat,
        int health,
        int armorClass,
        String challengeRating,
        int experience,
        int proficiencyBonus,
        int speed,
        StatsDto statsDto,

        List<String> languages,
        List<String> traits,
        List<String> actions,
        List<String> reactions,
        List<String> legendaryActions,
        List<String> savingThrows,
        List<String> skills,
        List<String> damageResistances,
        List<String> damageImmunities,
        List<String> conditionImmunities,
        List<String> senses
) {}
