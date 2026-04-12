package com.example.demo.dto;

public record MonsterResponse(
        Long id,
        String name,
        String description,
        String size,
        String type,
        int health,
        int armorClass,
        String challengeRating,
        int speed,
        StatsDto statsDto
) {}
