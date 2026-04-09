package com.example.demo.entity.initiativeTracker;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class Encounter {

    @NotBlank
    private String name;
    @Positive
    private int currentTurnIndex = 0;
    @Valid
    private List<CombatParticipant> participants = new ArrayList<>();

    public void sortByInitiative() {
        participants.sort((p1, p2) -> Integer.compare(p2.getInitiative(), p1.getInitiative()));
    }

    public void nextTurn() {
        currentTurnIndex = (currentTurnIndex + 1) % participants.size();
    }
}
