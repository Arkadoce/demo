package com.example.demo.service;

import com.example.demo.entity.Spell;
import com.example.demo.entity.model.spell.*;
import com.example.demo.repository.SpellRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpellService {

    private final SpellRepository spellRepository;

    public SpellService(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }

    public List<Spell> searchSpells() { return null; }

    public List<Spell> getSpells() {
        return spellRepository.findAll();
    }

    public List<Spell> getSpellsByName(String name) {
        return spellRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Spell> getSpellsByDamageType(DamageType type) {
        return spellRepository.findByDamageType(type);
    }

    public List<Spell> getSpellsBySchool(School school) {
        return spellRepository.findBySchool(school);
    }

    public List<Spell> getSpellsBySavingThrow(SavingThrow savingThrow) {
        return spellRepository.findBySavingThrow(savingThrow);
    }

    public List<Spell> getSpellsByLevel(int level) {
        return spellRepository.findByLevel(level);
    }

    public List<Spell> getSpellsByComponents(Components components) {
        return spellRepository.findByComponents(components);
    }

    public List<Spell> getSpellsByRitual(boolean ritual) {
        return spellRepository.findByRitual(ritual);
    }

    public List<Spell> getSpellsByConcentration(boolean concentration) {
        return spellRepository.findByConcentration(concentration);
    }

    public List<Spell> getSpellsByClasses(Classes classes) {
        return spellRepository.findByClasses(classes);
    }
}
