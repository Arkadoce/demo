package com.example.demo.service;

import com.example.demo.dto.SpellDto;
import com.example.demo.entity.CharacterClass;
import com.example.demo.entity.Spell;
import com.example.demo.entity.model.spell.*;
import com.example.demo.mapper.SpellMapper;
import com.example.demo.repository.SpellRepository;
import com.example.demo.specification.SpellSpecification;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SpellService {

    private final SpellRepository spellRepository;
    private final SpellMapper mapper;

    public List<SpellDto> getFilteredSpells(String name, Integer level, String characterClass, String school) {
        Specification<Spell> spec = SpellSpecification.filterSpell(name, level, characterClass, school);

        List<Spell> spells = spellRepository.findAll(spec);

        return spells.stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<SpellDto> getAll() {
        return spellRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    public SpellDto getSpellById(Long id) {
        return mapper.toDto(spellRepository.findById(id).orElseThrow());
    }
}
