package com.example.demo.controller;

import com.example.demo.dto.SpellDto;
import com.example.demo.entity.CharacterClass;
import com.example.demo.entity.Spell;
import com.example.demo.entity.model.spell.*;
import com.example.demo.service.SpellService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/spells")
@AllArgsConstructor
public class SpellController {

    private final SpellService spellService;

    @GetMapping("/filter")
    public List<SpellDto> filterSpells(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer level,
            @RequestParam(required = false) String characterClass,
            @RequestParam(required = false) String school) {

        return spellService.getFilteredSpells(name, level, characterClass, school);
    }
}
