package com.example.demo.mapper;

import com.example.demo.dto.MonsterDto;
import com.example.demo.entity.Monster;

public class MonsterMapper {
    public static Monster toMonster(MonsterDto dto) {
        if (dto == null) {
            return null;
        }
        return new Monster(
                dto.name(),
                dto.description(),
                dto.stats(),
                dto.size(),
                dto.monsterType(),
                dto.health(),
                dto.armorClass(),
                dto.challengeRating()
        );
    }

    public static MonsterDto toMonsterDto(Monster monster) {
        if (monster == null) {
            return null;
        }
        return new MonsterDto(
                monster.getName(),
                monster.getDescription(),
                monster.getStats(),
                monster.getSize(),
                monster.getMonsterType(),
                monster.getHealth(),
                monster.getArmorClass(),
                monster.getChallengeRating()
        );
    }
}
