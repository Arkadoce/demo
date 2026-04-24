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
                monster.getSize() != null ? monster.getSize().name() : null,
                monster.getType() != null ? monster.getType().name() : null,
                monster.getAlignment(),
                monster.getHabitat(),
                monster.getHealth(),
                monster.getArmorClass(),
                formatCr(monster.getChallengeRating()),
                monster.getExperiencePoints(),
                monster.getProficiencyBonus(),
                monster.getSpeed(),
                statsMapper.toDto(monster.getStats()),

                monster.getLanguages(),
                monster.getTraits(),
                monster.getActions(),
                monster.getReactions(),
                monster.getLegendaryActions(),
                monster.getSavingThrows(),
                monster.getSkills(),
                monster.getDamageResistances(),
                monster.getDamageImmunities(),
                monster.getConditionImmunities(),
                monster.getSenses()
        );
    }

    public Monster fromResponse(MonsterResponse response) {
        if (response == null) return null;

        Monster monster = new Monster();

        monster.setId(response.id());
        monster.setName(response.name());
        monster.setDescription(response.description());
        monster.setHealth(response.health());
        monster.setArmorClass(response.armorClass());
        monster.setSpeed(response.speed());
        monster.setChallengeRating(formatCrToDouble(response.challengeRating()));
        monster.setExperiencePoints(response.experience());
        monster.setAlignment(response.alignment());
        monster.setHabitat(response.habitat());

        if (response.size() != null && !response.size().isBlank()) {
            monster.setSize(CreatureSize.valueOf(response.size()));
        }
        if (response.type() != null && !response.type().isBlank()) {
            monster.setType(MonsterType.valueOf(response.type()));
        }

        monster.setStats(statsMapper.fromDto(response.statsDto()));

        monster.setLanguages(response.languages());
        monster.setTraits(response.traits());
        monster.setActions(response.actions());
        monster.setReactions(response.reactions());
        monster.setLegendaryActions(response.legendaryActions());
        monster.setSavingThrows(response.savingThrows());
        monster.setSkills(response.skills());
        monster.setDamageResistances(response.damageResistances());
        monster.setDamageImmunities(response.damageImmunities());
        monster.setConditionImmunities(response.conditionImmunities());
        monster.setSenses(response.senses());

        return monster;
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
