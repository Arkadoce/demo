package com.example.demo.converter;

import jakarta.persistence.AttributeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringListConverter implements AttributeConverter<List<String>, String> {

    private static final String SPLIT_CHAR = "; ";

    @Override
    public String convertToDatabaseColumn(List<String> strings) {
        return (strings == null || strings.isEmpty()) ? null : String.join(SPLIT_CHAR, strings);
    }

    @Override
    public List<String> convertToEntityAttribute(String s) {
        if (s == null ||  s.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(s.split(SPLIT_CHAR)));
    }
}
