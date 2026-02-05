package com.example.demo.dto;

public record CreateCharacterRequest(
    String name,
    int level,
    StatsDto stats,
    Long raceId
){}
