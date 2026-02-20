package com.example.demo.dto;

import com.example.demo.entity.Stats;
import com.example.demo.entity.model.MonsterType;
import com.example.demo.entity.model.CreatureSize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record MonsterDto(
        @NotBlank String name,
        @NotBlank String description,
        @Valid Stats stats,
        @NotBlank CreatureSize size,
        @NotBlank MonsterType monsterType,
        @Positive int health,
        @Positive int armorClass,
        @PositiveOrZero double challengeRating,
        @Positive int speed
) {}
