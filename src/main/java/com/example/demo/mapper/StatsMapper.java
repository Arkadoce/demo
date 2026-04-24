package com.example.demo.mapper;

import com.example.demo.dto.StatsDto;
import com.example.demo.entity.Stats;
import org.springframework.stereotype.Component;

@Component
public class StatsMapper {

    private static int calculatedMod(int score) {
        return Math.floorDiv(score - 10, 2) ;
    }

    public StatsDto toDto(Stats stats) {

        if (stats == null) {
            return null;
        }

        return new StatsDto(
                stats.Str(),
                calculatedMod(stats.Str()),
                stats.Dex(),
                calculatedMod(stats.Dex()),
                stats.Con(),
                calculatedMod(stats.Con()),
                stats.Int(),
                calculatedMod(stats.Int()),
                stats.Wis(),
                calculatedMod(stats.Wis()),
                stats.Cha(),
                calculatedMod(stats.Cha())
        );
    }

    public Stats fromDto(StatsDto dto) {

        if (dto == null) {
            return null;
        }

        return new Stats(
                dto.Str(),
                dto.Dex(),
                dto.Con(),
                dto.Wis(),
                dto.Int(),
                dto.Cha()
        );
    }


}
