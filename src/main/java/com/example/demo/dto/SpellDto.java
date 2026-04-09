package com.example.demo.dto;

import java.util.List;

public record SpellDto(
        Long id,
        String name,
        String school,
        List<String> classNames
) {
}
