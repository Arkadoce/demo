package com.example.demo.service.initiativeTracker;

import com.example.demo.entity.Creature;
import com.example.demo.entity.initiativeTracker.CombatParticipant;
import com.example.demo.entity.initiativeTracker.Encounter;
import com.example.demo.repository.initiativeTracker.CombatParticipantRepository;
import com.example.demo.repository.initiativeTracker.EncounterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncounterService {

    private final EncounterRepository encounterRepository;
    private final CombatParticipantRepository combatParticipantRepository;

    public EncounterService(EncounterRepository encounterRepository
    ,CombatParticipantRepository combatParticipantRepository) {
        this.encounterRepository = encounterRepository;
        this.combatParticipantRepository = combatParticipantRepository;
    }

    public Encounter getEncounterById(Long id) {
        return encounterRepository.findById(id).orElse(null);
    }

    public Encounter createEncounter(String name) {
        Encounter encounter = new Encounter();
        encounter.setName(name);
        encounter.setCurrentTurnIndex(0);
        return encounterRepository.save(encounter);
    }

    public CombatParticipant addCreatureToEncounter(Long currentId, Creature creature, int initiative) {
        Encounter encounter = encounterRepository.findById(currentId)
                .orElseThrow(() -> new RuntimeException("Бой не найден"));

        CombatParticipant participant = new CombatParticipant();
        participant.setName(creature.getName());
        participant.setMaxHp(creature.getMaxHp());
        participant.setCurrentHp(creature.getCurrentHp());
        participant.setInitiative(initiative);
        participant.setEncounter(encounter);

        return combatParticipantRepository.save(participant);
    }

    public Encounter nextTurn(Long encounterId) {
        Encounter encounter = encounterRepository.findById(encounterId)
                .orElseThrow(() -> new RuntimeException("Бой не найден"));

        List<CombatParticipant> participants = encounter.getParticipants();

        if (participants.isEmpty()) {
            return encounter;
        }

        int currentIndex = encounter.getCurrentTurnIndex();
        int listSize = participants.size();
        int nextIndex = (currentIndex + 1) % listSize;
        encounter.setCurrentTurnIndex(nextIndex);
        return encounter;
    }
}
