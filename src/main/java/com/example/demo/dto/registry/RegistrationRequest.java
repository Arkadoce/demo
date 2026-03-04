package com.example.demo.dto.registry;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegistrationRequest(
        @NotBlank String username,
        @Size(min = 6, message = "Пароль должен быть не короче 6 символов")
        String password
) {}
