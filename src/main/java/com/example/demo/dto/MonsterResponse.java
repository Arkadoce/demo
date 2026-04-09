package com.example.demo.dto;

import com.example.demo.entity.Stats;
import com.example.demo.entity.model.MonsterType;
import com.example.demo.entity.model.CreatureSize;

public record MonsterResponse(
        String name,
        String description,
        Stats stats,
        CreatureSize size,
        MonsterType monsterType,
        int health,
        int armorClass,
        double challengeRating
        //int speed
) {}
