package com.example.demo.mapper;

import com.example.demo.dto.MonsterResponse;
import com.example.demo.entity.bestiary.Monster;
import com.example.demo.entity.model.CreatureSize;
import com.example.demo.entity.model.MonsterType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MonsterMapper {

    private final StatsMapper statsMapper;

    public MonsterResponse toResponse(Monster monster) {

        if (monster == null) return null;

        return new MonsterResponse(
                monster.getId(),
                monster.getName(),
                monster.getDescription(),
                monster.getSize().name(),
                monster.getType().name(),
                monster.getHealth(),
                monster.getArmorClass(),
                formatCr(monster.getChallengeRating()),
                monster.getSpeed(),
                statsMapper.toDto(monster.getStats())
        );
    }

    public Monster fromResponse(MonsterResponse response) {
        if (response == null) return null;

        return new Monster(
                //response.id(),
                response.name(),
                response.description(),
                statsMapper.fromDto(response.statsDto()),
                response.speed(),
                CreatureSize.valueOf(response.size()),
                MonsterType.valueOf(response.type()),
                response.health(),
                response.armorClass(),
                formatCrToDouble(response.challengeRating())
        );
    }

    private String formatCr(Double cr) {
        if (cr == null) return "0";
        else if (cr == 0.125) return "1/8";
        else if (cr == 0.25) return "1/4";
        else if (cr == 0.5) return "1/2";
        return String.valueOf(cr.intValue());
    }

    private Double formatCrToDouble(String cr) {
        return switch (cr) {
            case "0" -> 0.0;
            case "1/8" -> 0.125;
            case "1/4" -> 0.25;
            case "1/2" -> 0.5;
            default -> Double.parseDouble(cr);
        };
    }
}
