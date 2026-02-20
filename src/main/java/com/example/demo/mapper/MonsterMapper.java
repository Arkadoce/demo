package com.example.demo.mapper;

import com.example.demo.dto.MonsterDto;
import com.example.demo.entity.bestiary.Monster;
import org.springframework.stereotype.Component;

@Component
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
                dto.challengeRating(),
                dto.speed()
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
                monster.getType(),
                monster.getMaxHp(),
                monster.getArmorClass(),
                monster.getChallengeRating(),
                monster.getSpeed()
        );
    }
}
