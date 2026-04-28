package com.example.demo.mapper;

import com.example.demo.dto.MonsterResponse;
import com.example.demo.dto.SpellDto;
import com.example.demo.entity.CharacterClass;
import com.example.demo.entity.Spell;
import com.example.demo.entity.bestiary.Monster;
import com.example.demo.entity.model.CreatureSize;
import com.example.demo.entity.model.MonsterType;
import com.example.demo.entity.model.spell.DamageType;
import com.example.demo.entity.model.spell.SavingThrow;
import com.example.demo.entity.model.spell.School;
import com.example.demo.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SpellMapper {

    private final StatsMapper statsMapper;
    private final CharacterService service;

    public SpellDto toDto(Spell spell) {

        if (spell == null) return null;

        return new SpellDto(
                spell.getId(),
                spell.getName(),
                spell.getDescription(),
                spell.getCastingTime(),
                spell.getDistance(),
                spell.getDuration(),

                spell.getLevel(),

                classesToString(spell.getClasses()),
                spell.getComponents(),
                spell.getRaces() != null ? spell.getRaces() : null,

                spell.getSchool().name(),
                spell.getDamageType() != null ? spell.getDamageType().name() : null,
                spell.getSavingThrow() != null ? spell.getSavingThrow().name() : null,

                spell.isRitual(),
                spell.isConcentration()
        );
    }

    public Spell fromDto(SpellDto dto) {
        if (dto == null) return null;

        Spell spell = new Spell();

        spell.setId(dto.id());
        spell.setName(dto.name());
        spell.setDescription(dto.description());
        spell.setCastingTime(dto.castingTime());
        spell.setDistance(dto.distance());
        spell.setDuration(dto.duration());

        spell.setLevel(dto.level());

        spell.setClasses(classesFromString(dto.classNames()));
        spell.setComponents(dto.components());
        spell.setRaces(dto.races());

        if (dto.school() != null && !dto.school().isBlank()) {
            spell.setSchool(School.valueOf(dto.school()));
        }
        spell.setDamageType(DamageType.valueOf(dto.damageType()));
        spell.setSavingThrow(SavingThrow.valueOf(dto.savingThrow()));

        spell.setRitual(dto.isRitual());
        spell.setConcentration(dto.isConcentration());

        return spell;
    }

    private List<String> classesToString(Set<CharacterClass> classes) {
        return classes.stream()
                .map(CharacterClass::getName)
                .toList();
    }

    private Set<CharacterClass> classesFromString(List<String> classes) {
        return classes.stream()
                .map(service::getByName)
                .collect(Collectors.toSet());
    }
}
