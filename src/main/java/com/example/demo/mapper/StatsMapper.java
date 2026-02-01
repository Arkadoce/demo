package com.example.demo.mapper;

import com.example.demo.dto.StatsDto;
import com.example.demo.entity.Stats;

public class StatsMapper {

    public static Stats toStats(StatsDto dto) {
        if (dto == null) {
            return new Stats(10, 10, 10, 10, 10, 10);
        }
        return new Stats(
                dto.strength(),
                dto.dexterity(),
                dto.constitution(),
                dto.intelligence(),
                dto.wisdom(),
                dto.charisma()
        );
    }

    public static StatsDto toStatsDto(Stats stats) {
        if (stats == null) return null;

        return new StatsDto(
                stats.Str(),
                stats.Dex(),
                stats.Con(),
                stats.Int(),
                stats.Wis(),
                stats.Cha()
        );
    }
}
