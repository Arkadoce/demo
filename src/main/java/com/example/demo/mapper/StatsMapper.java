package com.example.demo.mapper;

import com.example.demo.dto.StatsDto;
import com.example.demo.entity.Stats;

public class StatsMapper {

    public static Stats toStats(StatsDto dto) {
        if (dto == null) {
            return new Stats(10, 10, 10, 10, 10, 10);
        }
        return new Stats(
                dto.str(),
                dto.dex(),
                dto.con(),
                dto.intel(),
                dto.wis(),
                dto.cha()
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
