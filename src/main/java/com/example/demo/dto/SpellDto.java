package com.example.demo.dto;

import java.util.List;

public record SpellDto(
        Long id,
        String name,
        String description,
        String castingTime,
        String distance,
        String duration,

        int level,

        List<String> classNames,
        List<String> components,
        List<String> races,

        String school,
        String damageType,
        String savingThrow,

        boolean isRitual,
        boolean isConcentration
) {}
