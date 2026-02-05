package com.example.demo.mapper;

import com.example.demo.dto.CharacterResponse;
import com.example.demo.dto.RaceAbilityDto;
import com.example.demo.dto.RaceShortDto;
import com.example.demo.entity.Character.CharacterEntity;
import com.example.demo.entity.Character.Race.RaceEntity;

public class CharacterMapper {

    public static CharacterResponse toResponse(CharacterEntity entity) {
        RaceEntity race = entity.getRace();

        var raceDto = new RaceShortDto(
                race.getId(),
                race.getCode(),
                race.getName()
        );

        var abilities = race.getAbilities().stream()
                .map(a -> new RaceAbilityDto(
                        a.getId(),
                        a.getName(),
                        a.getDescription(),
                        a.getType() == null ? null : a.getType().name()
                ))
                .toList();

        return new CharacterResponse(
                entity.getId(),
                entity.getName(),
                entity.getLevel(),
                entity.bm(),
                entity.getExp(),
                StatsMapper.toStatsDto(entity.getStats()),
                raceDto,
                abilities
        );
    }
}
