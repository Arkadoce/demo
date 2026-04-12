package com.example.demo.converter;

import com.example.demo.entity.model.Language;
import jakarta.persistence.AttributeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LanguageListConverter implements AttributeConverter<List<Language>, String> {

    @Override
    public String convertToDatabaseColumn(List<Language> list) {
        return (list == null || list.isEmpty()) ? null : list.stream().map(Enum::name).collect(Collectors.joining(","));
    }

    @Override
    public List<Language> convertToEntityAttribute(String data) {
        if (data == null || data.isEmpty()) return new ArrayList<>();
        return Arrays.stream(data.split(","))
                .map(Language::valueOf)
                .collect(Collectors.toList());
    }
}
