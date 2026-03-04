package com.example.demo.entity.initiativeTracker;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.List;

@Entity
public class Encounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @Positive
    private int currentTurnIndex;

    @OneToMany(mappedBy = "encounter", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("initiative DESC")
    @Valid
    private List<CombatParticipant> participants;

    public Encounter() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCurrentTurnIndex() { return currentTurnIndex; }
    public void setCurrentTurnIndex(int currentTurnIndex) { this.currentTurnIndex = currentTurnIndex; }

    public Long getId() { return id; }

    public List<CombatParticipant> getParticipants() { return participants; }
    public void setParticipants(List<CombatParticipant> participants) { this.participants = participants; }
}
