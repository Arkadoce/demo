package com.example.demo.converter;

import com.example.demo.entity.model.Skill;
import jakarta.persistence.AttributeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SkillListConverter implements AttributeConverter<List<Skill>, String> {
    @Override
    public String convertToDatabaseColumn(List<Skill> list) {
        return (list == null || list.isEmpty()) ? null : list.stream().map(Enum::name).collect(Collectors.joining(","));
    }

    @Override
    public List<Skill> convertToEntityAttribute(String s) {
        if (s == null || s.isEmpty()) return new ArrayList<>();
        return Arrays.stream(s.split(","))
                     .map(Skill::valueOf)
                     .collect(Collectors.toList());
    }
}
