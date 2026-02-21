package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record ErrorResponse(
        @NotBlank String error,
        @NotBlank String message
) {}
