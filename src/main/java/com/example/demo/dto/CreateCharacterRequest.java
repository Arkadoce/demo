package com.example.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CreateCharacterRequest(
        @NotBlank String name,
        @Positive int level,
        @Valid StatsDto stats
){}
