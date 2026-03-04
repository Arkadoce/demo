package com.example.demo.controller;

import com.example.demo.entity.Creature;
import com.example.demo.entity.initiativeTracker.CombatParticipant;
import com.example.demo.entity.initiativeTracker.Encounter;
import com.example.demo.service.initiativeTracker.EncounterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encounters")
public class EncounterController {

    private EncounterService encounterService;

    public EncounterController(EncounterService encounterService) {
        this.encounterService = encounterService;
    }

    @PostMapping
    public Encounter addEncounter(@RequestParam(required = false) String name) {
        return encounterService.createEncounter(name);
    }

    @PostMapping("/{id}/add-monster/{monsterId}/{init}")
    public CombatParticipant addMonsterToEncounter(
            @PathVariable Long id,
            @PathVariable Creature creature,
            @RequestParam int init) {
        return encounterService.addCreatureToEncounter(id, creature, init);
    }

    @PostMapping("/{id}/add-monster/{characterId}/{init}")
    public CombatParticipant addCharacterToEncounter(
            @PathVariable Long id,
            @PathVariable Creature creature,
            @RequestParam int init) {
        return encounterService.addCreatureToEncounter(id, creature, init);
    }

    @GetMapping("/{id}/next")
    public Encounter nextTurnEncounter(@PathVariable Long id) {
        return encounterService.nextTurn(id);
    }

    @GetMapping("/{id}/current-packer")
    public CombatParticipant currentPackerEncounter(@PathVariable Long id) {
        Encounter encounter = encounterService.getEncounterById(id);
        List<CombatParticipant> participants = encounter.getParticipants();
        return participants.get(encounter.getCurrentTurnIndex());
    }

}
