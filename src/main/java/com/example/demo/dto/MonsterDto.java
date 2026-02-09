package com.example.demo.dto;

import com.example.demo.entity.Stats;
import com.example.demo.entity.model.MonsterType;
import com.example.demo.entity.model.Size;

public record MonsterDto(
        String name,
        String description,
        Stats stats,
        Size size,
        MonsterType monsterType,
        int health,
        int armorClass,
        double challengeRating
) {
}
