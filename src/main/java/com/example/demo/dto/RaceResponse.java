package com.example.demo.dto;

import java.util.List;

public record RaceResponse(
        Long id,
        String code,
        String name,
        String description,
        int speed,
        String size,
        int darkvision,
        List<RaceAbilityDto> abilities,
        List<RaceBonusDto> bonuses
) {}
