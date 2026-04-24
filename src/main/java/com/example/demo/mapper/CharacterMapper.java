package com.example.demo.mapper;

import com.example.demo.dto.CharacterResponse;
import com.example.demo.entity.CharacterEntity;
import org.springframework.stereotype.Component;

/**
 @Component
public class CharacterMapper {
    public static CharacterResponse toResponse(CharacterEntity entity) {
        return new CharacterResponse(
            entity.getId(),
            entity.getName(),
            entity.getLevel(),
            entity.bm(),
            StatsMapper.toStatsDto(entity.getStats())
        );

    }
}
 **/
