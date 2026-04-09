package com.example.demo.controller;

import com.example.demo.entity.CharacterClass;
import com.example.demo.entity.Spell;
import com.example.demo.entity.model.spell.*;
import com.example.demo.service.SpellService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/spells")
public class SpellController {

    private final SpellService spellService;

    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @GetMapping
    public List<Spell> getAllSpells() {
        return spellService.getSpells();
    }

    @GetMapping("/filter/level")
    public List<Spell> searchSpellsByLevel(int level) {
        return spellService.getSpellsByLevel(level);
    }

    @GetMapping("/filter/school")
    public List<Spell> searchSpellsBySchool(School school) {
        return spellService.getSpellsBySchool(school);
    }

    @GetMapping("/filter/damageType")
    public List<Spell> searchSpellsByDamageType(DamageType damageType) {
        return spellService.getSpellsByDamageType(damageType);
    }

    @GetMapping("/filter/classes")
    public List<Spell> searchSpellsByClasses(CharacterClass classes) {
        return spellService.getSpellsByClasses(classes);
    }

    @GetMapping("/filter/savingThrow")
    public List<Spell> searchSpellsBySavingThrow(SavingThrow savingThrow) {
        return spellService.getSpellsBySavingThrow(savingThrow);
    }

    @GetMapping("/filter/components")
    public List<Spell> searchSpellsByComponents(Components components) {
        return spellService.getSpellsByComponents(components);
    }

    @GetMapping("/filter/name")
    public List<Spell> searchSpellsByName(String name) {
        return spellService.getSpellsByName(name);
    }

    @GetMapping("/filter/ritual")
    public List<Spell> searchSpellsByRitual(boolean isRitual) {
        return spellService.getSpellsByRitual(isRitual);
    }

    @GetMapping("/filter/concentration")
    public List<Spell> searchSpellsByConcentration(boolean isConcentration) {
        return spellService.getSpellsByConcentration(isConcentration);
    }

}
